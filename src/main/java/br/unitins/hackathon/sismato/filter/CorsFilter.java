package br.unitins.hackathon.sismato.filter;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class CorsFilter implements ContainerResponseFilter, ContainerRequestFilter {

    @ConfigProperty(name = "quarkus.http.cors.origins")
    Optional<String> allowedOriginsProperty;

    @ConfigProperty(name = "quarkus.http.cors.methods", defaultValue = "GET,POST,PUT,DELETE,PATCH,OPTIONS")
    String allowMethods;

    @ConfigProperty(name = "quarkus.http.cors.headers", defaultValue = "Accept,Authorization,Content-Type,X-Requested-With")
    String allowHeaders;

    private boolean isOriginAllowed(String origin) {
        String configured = allowedOriginsProperty.orElse("");
        if (configured.isBlank()) {
            // fallback for local dev
            return origin != null && (origin.equals("http://localhost:3000") || origin.equals("http://127.0.0.1:3000"));
        }
        List<String> origins = Arrays.stream(configured.split(",")).map(String::trim).toList();
        return origin != null && origins.contains(origin);
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Handle preflight requests explicitly
        if ("OPTIONS".equalsIgnoreCase(requestContext.getMethod())) {
            String origin = requestContext.getHeaderString("Origin");
            if (origin != null && isOriginAllowed(origin)) {
                Response.ResponseBuilder ok = Response.ok();
                ok.header("Access-Control-Allow-Origin", origin);
                ok.header("Vary", "Origin");
                ok.header("Access-Control-Allow-Credentials", "true");
                ok.header("Access-Control-Allow-Methods", allowMethods);
                ok.header("Access-Control-Allow-Headers", allowHeaders);
                ok.header("Access-Control-Max-Age", "86400"); // 24H
                requestContext.abortWith(ok.build());
            }
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String origin = requestContext.getHeaderString("Origin");
        if (origin != null && isOriginAllowed(origin)) {
            responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", origin);
            responseContext.getHeaders().putSingle("Vary", "Origin");
            responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
            responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", allowMethods);
            responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", allowHeaders);
            // Expose useful headers to the browser
            responseContext.getHeaders().putSingle("Access-Control-Expose-Headers", "Authorization,X-Total-Count");
        }
    }
}
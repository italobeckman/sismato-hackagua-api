package br.unitins.hackathon.sismato.resource;

import br.unitins.hackathon.sismato.dto.FeatureCollectionDTO;
import br.unitins.hackathon.sismato.service.FeatureCollectionService;
import br.unitins.hackathon.sismato.service.FeatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/geo")
public class GeoResource {
    @Inject
    FeatureCollectionService featureCollectionService;

    @Inject
    FeatureService featureService;

    @POST
    public Object test(FeatureCollectionDTO featureCollectionDTO) {
        return featureCollectionService.save(featureCollectionDTO);
    }

    @GET
    public FeatureCollectionDTO getFeatureCollection() {
        return FeatureCollectionDTO.toDTO(featureService.getAllFeatures());
    }
}

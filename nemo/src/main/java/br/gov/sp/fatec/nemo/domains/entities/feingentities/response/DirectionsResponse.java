package br.gov.sp.fatec.nemo.domains.entities.feingentities.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DirectionsResponse {
    @JsonProperty("geocoded_waypoints")
    private List<GeocodedWaypoints> geocondedWaypoints;
    @JsonProperty("routes")
    private List<Routes> routes;


}

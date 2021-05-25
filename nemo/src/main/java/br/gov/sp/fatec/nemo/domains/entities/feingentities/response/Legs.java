package br.gov.sp.fatec.nemo.domains.entities.feingentities.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Legs {
    private TextValue distance;
    private TextValue duration;

    @JsonProperty("end_address")
    private String endAddresss;

    @JsonProperty("end_location")
    private LatLng endLocation;

    @JsonProperty("start_address")
    private String startAddresss;

}

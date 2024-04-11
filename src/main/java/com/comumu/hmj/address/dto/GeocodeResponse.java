package com.comumu.hmj.address.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeResponse {
    private GeocodeResult[] results;

    public GeocodeResult[] getResults() {
        return results;
    }

    public void setResults(GeocodeResult[] results) {
        this.results = results;
    }
}
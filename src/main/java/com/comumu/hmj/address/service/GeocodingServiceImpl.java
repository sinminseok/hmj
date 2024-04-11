package com.comumu.hmj.address.service;

import com.comumu.hmj.address.dto.GeocodeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class GeocodingServiceImpl implements GeocodingService{

    @Value("${google.api.key}")
    private String apiKey;

    private final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    @Override
    public GeocodeResponse getGeocode(String address) {
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = String.format("%s?address=%s&key=%s", GEOCODING_API_URL, address, apiKey);
        GeocodeResponse response = restTemplate.getForObject(requestUrl, GeocodeResponse.class);
        return response;
    }
}

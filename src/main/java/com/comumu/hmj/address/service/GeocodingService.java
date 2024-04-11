package com.comumu.hmj.address.service;

import com.comumu.hmj.address.dto.GeocodeResponse;

public interface GeocodingService {
    GeocodeResponse getGeocode(String address);
}

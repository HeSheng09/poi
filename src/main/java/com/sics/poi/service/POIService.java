package com.sics.poi.service;

import com.sics.poi.entity.POI;

import java.util.Map;

public interface POIService {
    public POI getPOIByCode(String code);

    public POI getPOIByName(String name);

    public Map<String,Object> getPOIsByProvince(String province);
}

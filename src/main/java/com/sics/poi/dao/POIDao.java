package com.sics.poi.dao;

import com.sics.poi.entity.POI;

public interface POIDao {
    public POI getPOIByCode(String code);

    public POI getPOIByName(String name);
}

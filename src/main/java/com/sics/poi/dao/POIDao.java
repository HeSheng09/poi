package com.sics.poi.dao;

import com.sics.poi.entity.POI;

import java.util.List;

public interface POIDao {
    public POI getPOIByCode(String code);

    public POI getPOIByName(String name);

    public List<POI> getPOIsByProvince(String province);
}

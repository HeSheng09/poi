package com.sics.poi.service.impl;

import com.sics.poi.dao.POIDao;
import com.sics.poi.entity.POI;
import com.sics.poi.service.POIService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class POIServiceImpl implements POIService {
    @Resource
    private POIDao poiDao;

    @Override
    public POI getPOIByCode(String code) {
        return poiDao.getPOIByCode(code);
    }

    @Override
    public POI getPOIByName(String name) {
        return poiDao.getPOIByName(name);
    }

    @Override
    public Map<String, Object> getPOIsByProvince(String province) {
        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> features = new ArrayList<>();
        List<POI> pois = poiDao.getPOIsByProvince(province);
        for (POI poi :
                pois) {
            features.add(poi.geojson());
        }
        json.put("features", features);
        json.put("type", "FeatureCollection");
        return json;
    }
}

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
        List<POI> pois = poiDao.getPOIsByProvince(province);

        Map<String, Object> result = new HashMap<>();

        // 以列表形式返回一批数据
        List<Map<String, Object>> POIs = new ArrayList<>();
        for (POI poi : pois) {
            Map<String, Object> feature = new HashMap<>();
            feature.put("feature", poi.geojson());
            feature.put("opr", poi.getImagePath());
            POIs.add(feature);
        }
        result.put("POIs", POIs);

        // 转换为一个整合的geojson
        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> features = new ArrayList<>();
        for (POI poi : pois) {
            features.add(poi.geojson());
        }
        json.put("features", features);
        json.put("type", "FeatureCollection");

        result.put("geojson", json);
        return result;
    }
}

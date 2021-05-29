package com.sics.poi.controller;

import com.sics.poi.entity.POI;
import com.sics.poi.service.POIService;
import com.sics.poi.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/poi")
public class POIController {
    @Resource
    private POIService poiService;

    private static final Logger logger = Logger.getLogger(POIController.class);

    @GetMapping(path = "/code/{code}")
    @ResponseBody
    public Map<String, Object> getPOIByCode(@PathVariable("code") String code) {
        POI poi = poiService.getPOIByCode(code);
        if (poi == null) {
            logger.info(String.format("code(%s) didn't exist", code));
            return ResponseUtil.response(0, null, null);
        } else {
            logger.info(String.format("ask for a POI by code: %s", code));
            return ResponseUtil.response(1, poi.geojson(), poi.getImagePath());
        }
    }

    @GetMapping(path = "/name/{name}")
    @ResponseBody
    public Map<String, Object> getPOIByName(@PathVariable("name") String name) {
        POI poi = poiService.getPOIByName(name);
        if (poi == null) {
            logger.info(String.format("name(%s) didn't exist", name));
            return ResponseUtil.response(0, null, null);
        } else {
            logger.info(String.format("ask for a POI by code: %s", name));
            return ResponseUtil.response(1, poi.geojson(), poi.getImagePath());
        }
    }

    @GetMapping(path = "/province/{province}")
    @ResponseBody
    public Map<String, Object> getPOIsByProvince(@PathVariable("province") String province) {
        Map<String, Object> poi = poiService.getPOIsByProvince(province);
        List<Map<String, Object>> features = (List<Map<String, Object>>) poi.get("POIs");
        if (features.isEmpty()) {
            logger.info(String.format("province(%s) didn't exist", province));
            return ResponseUtil.response(0, null, null);
        } else {
            logger.info(String.format("ask for POIs by code: %s", province));
            return ResponseUtil.response(1, poi, null);
        }
    }


    @GetMapping(path = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(String imageName) throws Exception {
        String imagepath = "./src/main/resources/static/";
        File file = new File(imagepath + imageName + ".jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        int n_bytes = inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }


}

package com.sics.poi.controller;

import com.sics.poi.entity.POI;
import com.sics.poi.service.POIService;
import com.sics.poi.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/poi")
public class POIController {
    @Resource
    private POIService poiService;

    private static final Logger logger = Logger.getLogger(POIController.class);

    @GetMapping(path = "/code")
    @ResponseBody
    public Map<String, Object> getPOIByCode(String code) {
        POI poi = poiService.getPOIByCode(code);
        logger.info(String.format("ask for a POI by code: %s",code));
        return ResponseUtil.response(1, poi.geojson());
    }

    @GetMapping(path = "/name")
    @ResponseBody
    public Map<String, Object> getPOIByName(String name) {
        POI poi = poiService.getPOIByName(name);
        logger.info(String.format("ask for a POI by code: %s",name));
        return ResponseUtil.response(1, poi.geojson());
    }

    @GetMapping(path = "/province")
    @ResponseBody
    public Map<String, Object> getPOIsByProvince(String province) {
        Map<String, Object> poi = poiService.getPOIsByProvince(province);
        logger.info(String.format("ask for POIs by code: %s",province));
        return ResponseUtil.response(1, poi);
    }


    @GetMapping(path = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(String imageName) throws Exception {
        String imagepath="./src/main/resources/static/";
        File file = new File(imagepath+imageName+".jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }



}

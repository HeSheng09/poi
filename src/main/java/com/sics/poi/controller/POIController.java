package com.sics.poi.controller;

import com.sics.poi.service.RedisService;
import com.sics.poi.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/poi")
public class POIController {
    @Resource
    private RedisService redisService;

    private static final Logger logger = Logger.getLogger(POIController.class);

    @GetMapping(path = "/{code}")
    @ResponseBody
    public Map<String, Object> getPOIByCode(@PathVariable("code") String code) {
        String data = redisService.get(code);
        return ResponseUtil.response(1, data);
    }
}

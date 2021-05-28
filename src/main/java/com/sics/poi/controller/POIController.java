package com.sics.poi.controller;

import com.sics.poi.entity.Test;
import com.sics.poi.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/test")
public class POIController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;

    private static final Logger logger = Logger.getLogger(POIController.class);

    @RequestMapping("/main")
    @ResponseBody
    public Test testRunning(@RequestParam(name = "id") int id) {
        System.out.println(id);
        Test t = new Test();
        t.setId(id);
        t.setInfo("测似成功");
        return t;
    }

    @RequestMapping("/redis")
    @ResponseBody
    public Test testRedisRunning(@RequestParam(name = "key") String key) {
        System.out.println(key);
        String info = redisTemplate.opsForValue().get(key);
        Test test = new Test();
        test.setId(1);
        test.setInfo(info);
        return test;
    }

    @RequestMapping("/jedis")
    @ResponseBody
    public Test testJedisRunning(@RequestParam(name = "key") String key) {
        System.out.println(key);
        String info = redisService.get(key);
        Test test = new Test();
        test.setId(1);
        test.setInfo(info);
        return test;
    }

    @RequestMapping("/headers")
    @ResponseBody
    public Map<String, Object> testHeadersRunning(@RequestHeader MultiValueMap<String, String> headers) {
        headers.forEach((key, value) -> {
            logger.info(String.format(
                    "Header '%s' = %s", key, String.join("/", value)));
        });
        Map<String, Object> result = new HashMap<>();
        result.put("code", 1);
        result.put("infor", "success");
        return result;
    }
}

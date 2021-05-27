package com.sics.poi.controller;

import com.sics.poi.entity.Test;
import com.sics.poi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class POIController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/test")
    @ResponseBody
    public Test testRunning(@RequestParam(name = "id") int id) {
        System.out.println(id);
        Test t = new Test();
        t.setId(id);
        t.setInfo("测似成功");
        return t;
    }

    @RequestMapping("/redis/test")
    @ResponseBody
    public Test testRedisRunning(@RequestParam(name = "key") String key) {
        System.out.println(key);
        String info = redisTemplate.opsForValue().get(key);
        Test test = new Test();
        test.setId(1);
        test.setInfo(info);
        return test;
    }

    @RequestMapping("/jedis/test")
    @ResponseBody
    public Test testJedisRunning(@RequestParam(name = "key") String key) {
        System.out.println(key);
        String info = redisService.get(key);
        Test test = new Test();
        test.setId(1);
        test.setInfo(info);
        return test;
    }
}

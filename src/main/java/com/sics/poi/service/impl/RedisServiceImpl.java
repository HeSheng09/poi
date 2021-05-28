package com.sics.poi.service.impl;

import com.sics.poi.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService {
    private static final Logger logger = Logger.getLogger(RedisServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;    //jedisPool不属于springboot框架支持的redis类,所以需要自行注入到spring中。通过配置类RedisConfig类注入的

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResourceObject(jedis);
        }
    }

    @Override
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.set(key, value);
            logger.info("Redis set success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: " + e.getMessage() + " - " + key + ", value:" + value);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    public String get(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.get(key);
            logger.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: " + e.getMessage() + " - " + key + ", value:" + result);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    @Override
    public Long ttl(String key) {
        Long result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.ttl(key);
            logger.info("Redis ttl - " + key + " " + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis ttl error: " + e.getMessage() + " - " + key + " " + result);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    @Override
    public void pexpire(String key, Long milliseconds) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.pexpire(key, milliseconds);
            logger.info("Redis expire  success - " + key + ", milliseconds:" + milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis expire error: " + e.getMessage() + " - " + key + ", milliseconds:" + milliseconds);
        } finally {
            returnResource(jedis);
        }
    }
}

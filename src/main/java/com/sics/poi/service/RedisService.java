package com.sics.poi.service;

import redis.clients.jedis.Jedis;

public interface RedisService {

    public Jedis getResource();

    public void returnResource(Jedis jedis);

    public void set(String key, String value);

    public String get(String key);

    public Long ttl(String key);

    public void pexpire(String key, Long milliseconds);
}

package com.sics.poi.config;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private static final Logger logger = Logger.getLogger(RedisConfig.class);
    private String host;
    private int port;
    private int timeout;

    public JedisPoolConfig getRedisConfig() {
        return new JedisPoolConfig();
    }

    @Bean//@Bean注解将一个配置类的方法的返回值定义为一个bean，注册到spring里面
    public JedisPool getJedisPool() {
        JedisPoolConfig config = getRedisConfig();
        logger.info("init JedisPool ...");
        return new JedisPool(config, host, port);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

}

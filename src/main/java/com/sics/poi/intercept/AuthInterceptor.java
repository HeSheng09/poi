package com.sics.poi.intercept;

import com.sics.poi.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
    @Resource
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(">>>AuthInterceptor>>>");
        String user = request.getHeader("user");
        String token = request.getHeader("token");
        logger.info(String.format("user: [ %s ], token : [ %s ]", user, token));
        // check token
        if (user == null || "".equals(user) || token == null || "".equals(token)) {
            logger.info("invalid user or token");

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print("{\"state\":0,\"msg\":\"invalid user or token!\"}");

            return false;
        } else if (token.equals(redisService.get(user))) {
            logger.info("authority passed!");
            return true;
        } else {
            logger.info("authority failed!");

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print("{\"state\":0,\"msg\":\"authority failed!\"}");

            return false;
        }
    }
}

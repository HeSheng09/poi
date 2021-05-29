package com.sics.poi.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    /** 格式化返回值
    * @author: hesheng
    * @date: 2021/5/30
     * @param status 状态码
     * @param data 数据
    * @return: java.util.Map
    */
    public static Map<String, Object> response(int status, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("data", data);
        return result;
    }

    /** 格式化返回值
    * @author: hesheng
    * @date: 2021/5/30
     * @param status 状态码
     * @param data 数据
     * @param opr 拓展操作
    * @return: java.util.Map
    */
    public static Map<String, Object> response(int status, Object data, Object opr) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("data", data);
        result.put("opr", opr);
        return result;
    }
}

package com.sics.poi.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static Map<String, Object> response(int status, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("data", data);
        return result;
    }

    public static Map<String, Object> response(int status, Object data, Object opr) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("data", data);
        result.put("opr", opr);
        return result;
    }
}

package com.sics.poi.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static Map<String, Object> response(int state, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("state", state);
        result.put("data", data);
        return result;
    }
}

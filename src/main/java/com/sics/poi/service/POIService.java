package com.sics.poi.service;

import com.sics.poi.entity.POI;

import java.util.Map;

public interface POIService {
    /** 根据code获取POI
    * @author hesheng
    * @date 2021/5/30
    * @param code POI代码
    * @return  com.sics.poi.entity.POI
    */
    public POI getPOIByCode(String code);

    /** 根据name获取POI
    * @author hesheng
    * @date 2021/5/30
    * @param name POI名称
    * @return  com.sics.poi.entity.POI
    */
    public POI getPOIByName(String name);

    /** 根据省份简称获取一组POI
    * @author hesheng
    * @date 2021/5/30
    * @param province 省份简称
    * @return  java.util.Map
    */
    public Map<String,Object> getPOIsByProvince(String province);
}

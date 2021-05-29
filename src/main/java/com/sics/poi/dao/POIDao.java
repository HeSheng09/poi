package com.sics.poi.dao;

import com.sics.poi.entity.POI;

import java.util.List;

public interface POIDao {
    /** 根据code查询得到POI
    * @author hesheng
    * @date 2021/5/30
    * @param code POI代码
    * @return  com.sics.poi.entity.POI
    */
    public POI getPOIByCode(String code);

    /** 根据name查询得到POI
    * @author hesheng
    * @date 2021/5/30
    * @param name POI的名称
    * @return  com.sics.poi.entity.POI
    */
    public POI getPOIByName(String name);

    /** 根据省份简称查询一批POI
    * @author hesheng
    * @date 2021/5/30
    * @param province 省份简称
    * @return  java.util.List
    */
    public List<POI> getPOIsByProvince(String province);
}

package com.sics.poi.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POI {
    private String code;
    private String province;
    private String name;
    private String county;
    private double area;
    private String object;
    private String type;
    private String level;
    private String time;
    private String apartment;
    private double lon;
    private double lat;
    private String check;
    private String imagePath;
    @Override
    public String toString() {
        return "POI{" +
                "code='" + code + '\'' +
                ", province='" + province + '\'' +
                ", name='" + name + '\'' +
                ", county='" + county + '\'' +
                ", area=" + area +
                ", object='" + object + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", time='" + time + '\'' +
                ", apartment='" + apartment + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", check='" + check + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public Map<String, Object> geojson() {
        Map<String, Object> json = new HashMap<>();
        json.put("type", "Feature");

        Map<String, Object> geometry = new HashMap<>();
        geometry.put("type", "Point");
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(lon);
        coordinates.add(lat);
        geometry.put("coordinates", coordinates);
        json.put("geometry", geometry);

        Map<String, Object> properties = new HashMap<>();
        properties.put("code", code);
        properties.put("Province", province);
        properties.put("name", name);
        properties.put("county", county);
        properties.put("area", area);
        properties.put("object", object);
        properties.put("type", type);
        properties.put("level", level);
        properties.put("time", time);
        properties.put("apartment", apartment);
        properties.put("check", check);
        properties.put("imagePath",imagePath);
        json.put("properties", properties);

        return json;
    }

//    public String geojson() {
//        return "{\"type\":\"Feature\"," +
//                "\"geometry\":{\"type\":\"Point\",\"coordinates\":[" + lon + "," + lat + "]}," +
//                "\"properties\":{" +
//                "\"code\":\"" + code + "\",\"Province\":\"" + province + "\",\"name\":\"" + name + "\"," +
//                "\"county\":\"" + county + "\",\"area\":" + area + ",\"object\":\"" + object + "\"," +
//                "\"type\":\"" + type + "\",\"level\":\"" + level + "\",\"time\":" + time + "," +
//                "\"apartment\":\"" + apartment + "\",\"check\":\"" + check + "\"}}";
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

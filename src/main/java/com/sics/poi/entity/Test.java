package com.sics.poi.entity;

public class Test {
    private String info;
    private int id;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "info='" + info + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

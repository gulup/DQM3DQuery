package com.gulup.dqm3dquery.bean;

import java.io.Serializable;

public class Monster implements Serializable{
    
    private int mid;
    private String name;
    private int type;
    private int level;
    private int size;
    private String att;
    private String feature;
    private String featurecn;
    private String parents;
    private String get;
    
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getAtt() {
        return att;
    }
    public void setAtt(String att) {
        this.att = att;
    }
    public String getFeature() {
        return feature;
    }
    public void setFeature(String feature) {
        this.feature = feature;
    }
    public String getFeaturecn() {
        return featurecn;
    }
    public void setFeaturecn(String featurecn) {
        this.featurecn = featurecn;
    }
    public String getParents() {
        return parents;
    }
    public void setParents(String parents) {
        this.parents = parents;
    }
    public String getGet() {
        return get;
    }
    public void setGet(String get) {
        this.get = get;
    }
    
}

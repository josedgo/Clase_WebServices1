package com.jdavi.getservice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Earthquake { //Modelos de datos

    @SerializedName("datetime")
    @Expose
    private String datetime;//atributos del earthqueake
    @SerializedName("depth")
    @Expose
    private Double depth;//atributos del earthqueake
    @SerializedName("lng")
    @Expose
    private Double lng;//atributos del earthqueake
    @SerializedName("src")
    @Expose
    private String src;//atributos del earthqueake
    @SerializedName("eqid")
    @Expose
    private String eqid;//atributos del earthqueake
    @SerializedName("magnitude")
    @Expose
    private Double magnitude;//atributos del earthqueake
    @SerializedName("lat")
    @Expose
    private Double lat;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}

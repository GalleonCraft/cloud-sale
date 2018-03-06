package com.foalnet.cloudsale.bo;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/25 0025.
 */
public class InspRecord {
    private String idno;
    private String name;
    //记录内容
    private String recordContent;
    //记录类型
    private String recordType;
    //操作地址
    private String recordAddr;
    private String recordStation;
    private String reason;
    private String telephone;
    private String visitAddr;
    //维度
    private Double lat;
    //经度
    private Double lng;
    //记录时间
    private Date recordTime;

    public String getRecordStation() {
        return recordStation;
    }

    public void setRecordStation(String recordStation) {
        this.recordStation = recordStation;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordAddr() {
        return recordAddr;
    }

    public void setRecordAddr(String recordAddr) {
        this.recordAddr = recordAddr;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVisitAddr() {
        return visitAddr;
    }

    public void setVisitAddr(String visitAddr) {
        this.visitAddr = visitAddr;
    }
}

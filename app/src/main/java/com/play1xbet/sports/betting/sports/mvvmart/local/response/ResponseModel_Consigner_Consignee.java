package com.play1xbet.sports.betting.sports.mvvmart.local.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseModel_Consigner_Consignee {
    public String CityName;
    @SerializedName("CompGroupCode")
    @Expose
    private Integer compGroupCode;
    @SerializedName("Goods")
    @Expose
    private String goods;
    @SerializedName("Pcode")
    @Expose
    private Integer Pcode;
    @SerializedName("PName")
    @Expose
    private String pName;
    @SerializedName("Station")
    @Expose
    private String station;
    public String Code_No;
    public String Pary_Name;
    public String Vehicle_Type;
    public String StateName;
    public String CityCode;
    public String StateCode;
    public String CityAddress;
    public Integer PartyWiseCityCode;

    private boolean isSelected;

    public ResponseModel_Consigner_Consignee(String citynm, String citycod, String statcod, String statnm) {
        this.CityName = citynm;
        this.CityCode = citycod;
        this.StateCode = statcod;
        this.StateName = statnm;
    }

    public Integer getPCode() {
        return this.Pcode;
    }

    public void setPCode(Integer pCode2) {
        this.Pcode = pCode2;
    }

    public String getPName() {
        return this.pName;
    }

    public void setPName(String pName2) {
        this.pName = pName2;
    }

    public Integer getCompGroupCode() {
        return this.compGroupCode;
    }

    public void setCompGroupCode(Integer compGroupCode2) {
        this.compGroupCode = compGroupCode2;
    }

    public String getStation() {
        return this.station;
    }

    public void setStation(String station2) {
        this.station = station2;
    }

    public String getGoods() {
        return this.goods;
    }

    public void setGoods(String goods2) {
        this.goods = goods2;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

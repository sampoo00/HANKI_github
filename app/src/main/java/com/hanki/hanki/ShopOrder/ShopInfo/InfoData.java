package com.hanki.hanki.ShopOrder.ShopInfo;

public class InfoData {
    private String businessNum;
    private String shopName;
    private double pointX;
    private double pointY;
    private String ownerName;
    private String holiday;
    private String runTime;
    private String breakTime;
    private String addr;
    private String detailAddr;
    private String shopCallNum;

    @Override
    public String toString() {
        return "InfoData{" +
                "businessNum='" + businessNum + '\'' +
                ", shopName='" + shopName + '\'' +
                ", pointX=" + pointX +
                ", pointY=" + pointY +
                ", ownerName='" + ownerName + '\'' +
                ", holiday='" + holiday + '\'' +
                ", runTime='" + runTime + '\'' +
                ", breakTime='" + breakTime + '\'' +
                ", addr='" + addr + '\'' +
                ", detailAddr='" + detailAddr + '\'' +
                ", shopCallNum='" + shopCallNum + '\'' +
                '}';
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public String getShopName() {
        return shopName;
    }

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getHoliday() {
        return holiday;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public String getAddr() {
        return addr;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public String getShopCallNum() {
        return shopCallNum;
    }
}

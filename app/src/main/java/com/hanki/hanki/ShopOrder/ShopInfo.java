package com.hanki.hanki.ShopOrder;

public class ShopInfo {
    String runTime;
    String breakTime;
    String holiday;
    String phoneNum;
    String shopMap;
    String ownerName;
    String businessName;
    String businessNum;

    public ShopInfo(String runTime, String breakTime, String holiday, String phoneNum,
                    String shopMap, String ownerName, String businessName, String businessNum) {
        this.runTime = runTime;
        this.breakTime = breakTime;
        this.holiday = holiday;
        this.phoneNum = phoneNum;
        this.shopMap = shopMap;
        this.ownerName = ownerName;
        this.businessName = businessName;
        this.businessNum = businessNum;
    }
}

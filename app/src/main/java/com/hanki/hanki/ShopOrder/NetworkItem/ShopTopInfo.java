package com.hanki.hanki.ShopOrder.NetworkItem;

import java.util.ArrayList;

public class ShopTopInfo {
    public String shopCode;
    public String shopName;
    public int orderType;
    public String wishYn;
    public int shopScoreAvg;
    public int reviewNum;
    public String origin;
    public ArrayList<MenuData> list;

    @Override
    public String toString() {
        return "ShopTopInfo{" +
                "shopCode='" + shopCode + '\'' +
                ", shopName='" + shopName + '\'' +
                ", orderType=" + orderType +
                ", wishYn='" + wishYn + '\'' +
                ", shopScoreAvg=" + shopScoreAvg +
                ", reviewNum=" + reviewNum +
                ", origin='" + origin + '\'' +
                ", list=" + list +
                '}';
    }
}

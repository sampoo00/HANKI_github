package com.hanki.hanki.ShopOrder.NetworkItem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class ShopTopInfo implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}

package com.hanki.hanki.ShopOrder.NetworkItem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MenuData implements Parcelable{
    String menuName;
    int menuPrice;
    String menuImgId;
    int pickUpType;
    String category;
    String soldOutYn;
    String menuDoc;
    String toppingKey;

    @Override
    public String toString() {
        return "MenuData{" +
                "menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuImgId='" + menuImgId + '\'' +
                ", pickUpType=" + pickUpType +
                ", category='" + category + '\'' +
                ", soldOutYn='" + soldOutYn + '\'' +
                ", menuDoc='" + menuDoc + '\'' +
                ", toppingKey='" + toppingKey + '\'' +
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

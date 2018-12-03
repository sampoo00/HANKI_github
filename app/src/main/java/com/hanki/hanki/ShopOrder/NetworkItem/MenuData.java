package com.hanki.hanki.ShopOrder.NetworkItem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MenuData {
    private String menuName;
    private int menuPrice;
    private String menuImgId;
    private int pickUpType;
    private String category;
    private String soldOutYn;
    private String menuDoc;
    private String toppingKey;

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

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public String getMenuImgId() {
        return menuImgId;
    }

    public int getPickUpType() {
        return pickUpType;
    }

    public String getCategory() {
        return category;
    }

    public String getSoldOutYn() {
        return soldOutYn;
    }

    public String getMenuDoc() {
        return menuDoc;
    }

    public String getToppingKey() {
        return toppingKey;
    }
}

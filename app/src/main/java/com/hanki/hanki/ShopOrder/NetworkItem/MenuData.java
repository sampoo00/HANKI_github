package com.hanki.hanki.ShopOrder.NetworkItem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MenuData implements Parcelable {
    private String menuName;
    private int menuPrice;
    private String menuImgId;
    private int pickUpType;
    private String category;
    private String soldOutYn;
    private String menuDoc;
    private String toppingKey;

    protected MenuData(Parcel in) {
        menuName = in.readString();
        menuPrice = in.readInt();
        menuImgId = in.readString();
        pickUpType = in.readInt();
        category = in.readString();
        soldOutYn = in.readString();
        menuDoc = in.readString();
        toppingKey = in.readString();
    }

    //Creator
    public static final Creator<MenuData> CREATOR = new Creator<MenuData>() {
        @Override
        public MenuData createFromParcel(Parcel in) {
            return new MenuData(in);
        }

        @Override
        public MenuData[] newArray(int size) {
            return new MenuData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(menuName);
        dest.writeInt(menuPrice);
        dest.writeString(menuImgId);
        dest.writeInt(pickUpType);
        dest.writeString(category);
        dest.writeString(soldOutYn);
        dest.writeString(menuDoc);
        dest.writeString(toppingKey);
    }
}

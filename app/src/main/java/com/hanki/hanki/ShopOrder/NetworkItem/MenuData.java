package com.hanki.hanki.ShopOrder.NetworkItem;

public class MenuData {
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
}

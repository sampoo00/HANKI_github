package com.hanki.hanki.Main;

public class ShopName {
    String result;
    String shopName;
    String description;
    String shopImgUrl;
    String shopKey;

    public String getResult() {
        return result;
    }

    public String getShopName() {
        return shopName;
    }

    public String getDescription() {
        return description;
    }

    public String getShopImgUrl() {
        return shopImgUrl;
    }

    public String getShopKey() {
        return shopKey;
    }

    @Override
    public String toString() {
        return "ShopName{" +
                "result='" + result + '\'' +
                ", shopName='" + shopName + '\'' +
                ", description='" + description + '\'' +
                ", shopImgUrl='" + shopImgUrl + '\'' +
                ", shopKey='" + shopKey + '\'' +
                '}';
    }
}

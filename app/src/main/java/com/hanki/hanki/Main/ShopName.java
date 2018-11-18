package com.hanki.hanki.Main;

public class ShopName {
    private String result;
    private String shopName;
    private String description;
    private String shopKey;

    public ShopName(String result, String shopName, String description, String shopKey) {
        this.result = result;
        this.shopName = shopName;
        this.description = description;
        this.shopKey = shopKey;
    }

    public String getResult() {
        return result;
    }

    public String getShopName() {
        return shopName;
    }

    public String getDescription() {
        return description;
    }

    public String getShopKey() {
        return shopKey;
    }
}

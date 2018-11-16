package com.hanki.hanki.ShopOrder.ShopMenu;

public class ShopRecMenuData {
    String recMenuName;
    int recMenuPrice;

    public ShopRecMenuData(String recMenuName, int recMenuPrice) {
        this.recMenuName = recMenuName;
        this.recMenuPrice = recMenuPrice;
    }

    public String getRecMenuName() {
        return recMenuName;
    }

    public void setRecMenuName(String recMenuName) {
        this.recMenuName = recMenuName;
    }

    public int getRecMenuPrice() {
        return recMenuPrice;
    }

    public void setRecMenuPrice(int recMenuPrice) {
        this.recMenuPrice = recMenuPrice;
    }
}

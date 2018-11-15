package com.hanki.hanki.ShopOrder.ShopMenu;

public class ShopOptMenuData {
    public String optMenuTitle;
    public String optMenuPrice;
    public String optMenuCount;

    public ShopOptMenuData(String optMenuTitle, String optMenuPrice) {
        this.optMenuTitle = optMenuTitle;
        this.optMenuPrice = optMenuPrice;
    }

    public String getOptMenuTitle() {
        return optMenuTitle;
    }

    public void setOptMenuTitle(String optMenuTitle) {
        this.optMenuTitle = optMenuTitle;
    }

    public String getOptMenuPrice() {
        return optMenuPrice;
    }

    public void setOptMenuPrice(String optMenuPrice) {
        this.optMenuPrice = optMenuPrice;
    }

    public String getOptMenuCount() {
        return optMenuCount;
    }

    public void setOptMenuCount(String optMenuCount) {
        this.optMenuCount = optMenuCount;
    }




}

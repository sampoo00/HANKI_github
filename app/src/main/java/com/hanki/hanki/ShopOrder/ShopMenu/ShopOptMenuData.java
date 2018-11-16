package com.hanki.hanki.ShopOrder.ShopMenu;

public class ShopOptMenuData {
    public String optMenuTitle;
    public int optMenuPrice;
    public int optMenuCount;

    public ShopOptMenuData(String optMenuTitle, int optMenuPrice) {
        this.optMenuTitle = optMenuTitle;
        this.optMenuPrice = optMenuPrice;
    }

    public String getOptMenuTitle() {
        return optMenuTitle;
    }

    public void setOptMenuTitle(String optMenuTitle) {
        this.optMenuTitle = optMenuTitle;
    }

    public int getOptMenuPrice() { return optMenuPrice;   }

    public void setOptMenuPrice(int optMenuPrice) {
        this.optMenuPrice = optMenuPrice;
    }

    public int getOptMenuCount() {
        return optMenuCount;
    }

    public void setOptMenuCount(int optMenuCount) {
        this.optMenuCount = optMenuCount;
    }




}

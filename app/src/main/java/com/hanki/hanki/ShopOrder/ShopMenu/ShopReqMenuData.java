package com.hanki.hanki.ShopOrder.ShopMenu;

public class ShopReqMenuData {
    public String getReqMenuSize() {
        return reqMenuSize;
    }

    public void setReqMenuSize(String reqMenuSize) {
        this.reqMenuSize = reqMenuSize;
    }

    public String getReqMenuPeople() {
        return reqMenuPeople;
    }

    public void setReqMenuPeople(String reqMenuPeople) {
        this.reqMenuPeople = reqMenuPeople;
    }

    public int getReqMenuPrice() {
        return reqMenuPrice;
    }

    public void setReqMenuPrice(int reqMenuPrice) {
        this.reqMenuPrice = reqMenuPrice;
    }

    public String reqMenuSize;
    public String reqMenuPeople;
    public int reqMenuPrice;

    public ShopReqMenuData(String reqMenuSize, String reqMenuPeople, int reqMenuPrice) {
        this.reqMenuSize = reqMenuSize;
        this.reqMenuPeople = reqMenuPeople;
        this.reqMenuPrice = reqMenuPrice;
    }
}

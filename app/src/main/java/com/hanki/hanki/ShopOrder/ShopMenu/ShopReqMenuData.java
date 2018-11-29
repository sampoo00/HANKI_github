package com.hanki.hanki.ShopOrder.ShopMenu;

public class ShopReqMenuData {
    public String menuSize;
    public String menuPeople;
    public int menuPrice;

    public ShopReqMenuData(String menuSize, String menuPeople, int menuPrice) {
        this.menuSize = menuSize;
        this.menuPeople = menuPeople;
        this.menuPrice = menuPrice;
    }

    public String getMenuSize() {
        return menuSize;
    }

    public void setMenuSize(String menuSize) {
        this.menuSize = menuSize;
    }

    public String getMenuPeople() {
        return menuPeople;
    }

    public void setMenuPeople(String menuPeople) {
        this.menuPeople = menuPeople;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
}

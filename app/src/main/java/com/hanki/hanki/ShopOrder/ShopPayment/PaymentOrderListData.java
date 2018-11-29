package com.hanki.hanki.ShopOrder.ShopPayment;

import android.widget.ImageView;

public class PaymentOrderListData {
    //메뉴 이미지 넣은 버전
//    public String menuImage;
//    public String menuName;
//    public String[] menuTopping; // menuTopping에 size가 들어가있음.
//
//
//    public PaymentOrderListData(String menuImage, String menuName, String[] menuTopping) {
//        this.menuImage = menuImage;
//        this.menuName = menuName;
//        this.menuTopping = menuTopping;
//    }
//
//    public String getMenuImage() {
//        return menuImage;
//    }
//
//    public void setMenuImage(String menuImage) {
//        this.menuImage = menuImage;
//    }
//
//    public String getMenuName() {
//        return menuName;
//    }
//
//    public void setMenuName(String menuName) {
//        this.menuName = menuName;
//    }
//
//    public String[] getMenuTopping() {
//        return menuTopping;
//    }
//
//    public void setMenuTopping(String[] menuTopping) {
//        this.menuTopping = menuTopping;
//    }

    public String menuName;
    public String menuSize;
    public String[] menuTopping; // menuTopping에 size가 들어가있음.4

    public PaymentOrderListData(String menuName, String menuSize, String[] menuTopping) {
        this.menuName = menuName;
        this.menuSize = menuSize;
        this.menuTopping = menuTopping;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuSize() {
        return menuSize;
    }

    public void setMenuSize(String menuSize) {
        this.menuSize = menuSize;
    }

    public String[] getMenuTopping() {
        return menuTopping;
    }

    public void setMenuTopping(String[] menuTopping) {
        this.menuTopping = menuTopping;
    }
}

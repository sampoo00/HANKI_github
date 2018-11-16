package com.hanki.hanki.NavigationBar.OrderHistory;

public class OrderHistory {
    String shopName;
    String shopImage;
    String orderDate;
    int pickUpType;
    String orderFinish;

    public OrderHistory(String shopName, String shopImage, String orderDate, int pickUpType, String orderFinish) {
        this.shopName = shopName;
        this.shopImage = shopImage;
        this.orderDate = orderDate;
        this.pickUpType = pickUpType;
        this.orderFinish = orderFinish;
    }
}

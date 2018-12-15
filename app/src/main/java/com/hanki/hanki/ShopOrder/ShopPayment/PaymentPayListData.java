package com.hanki.hanki.ShopOrder.ShopPayment;

public class PaymentPayListData {
    public String payName;
    public int payImg;

    public PaymentPayListData(String payName, int payImg) {
        this.payName = payName;
        this.payImg = payImg;
    }

    public int getPayImg() {
        return payImg;
    }

    public void setPayImg(int payImg) {
        this.payImg = payImg;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }
}

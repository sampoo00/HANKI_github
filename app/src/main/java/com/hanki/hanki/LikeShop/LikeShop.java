package com.hanki.hanki.LikeShop;

public class LikeShop {
    String UUID;
    String shopName;
    String shopImage;
    float shopScore;
    int reviewNum;
    String mainMenu;
    int pickUpType;

    public LikeShop(String UUID, String shopName, String shopImage, float shopScore, int reviewNum, String mainMenu, int pickUpType) {
        this.UUID = UUID;
        this.shopName = shopName;
        this.shopImage = shopImage;
        this.shopScore = shopScore;
        this.reviewNum = reviewNum;
        this.mainMenu = mainMenu;
        this.pickUpType = pickUpType;
    }
}

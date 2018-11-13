package com.hanki.hanki.NearByShop;

public class NearbyShop {
    String UUID;
    String shopName;
    String shopImage;
    float shopScore;
    int reviewNum;
    String mainMenu;
    int pickUpType;

    public NearbyShop(String UUID, String shopName, String shopImage, float shopScore, int reviewNum, String mainMenu, int pickUpType) {
        this.UUID = UUID;
        this.shopName = shopName;
        this.shopImage = shopImage;
        this.shopScore = shopScore;
        this.reviewNum = reviewNum;
        this.mainMenu = mainMenu;
        this.pickUpType = pickUpType;
    }
}

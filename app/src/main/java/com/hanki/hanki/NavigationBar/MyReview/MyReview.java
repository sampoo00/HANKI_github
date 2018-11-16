package com.hanki.hanki.NavigationBar.MyReview;

public class MyReview {
    String shopName;
    String userName;
    String userImage;
    int userScore;
    String writeDate;
    String review;

    public MyReview(String shopName, String userName, String userImage, int userScore, String writeDate, String review) {
        this.shopName = shopName;
        this.userName = userName;
        this.userImage = userImage;
        this.userScore = userScore;
        this.writeDate = writeDate;
        this.review = review;
    }
}

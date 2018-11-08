package com.hanki.hanki.Review;

import java.util.Date;

public class ReviewData {
    String userEmail;
    String UUID;
    int userScore;
    String writeDate;
    String review;

    public ReviewData(String userEmail, String UUID, int userScore, String writeDate, String review) {
        this.userEmail = userEmail;
        this.UUID = UUID;
        this.userScore = userScore;
        this.writeDate = writeDate;
        this.review = review;
    }
}

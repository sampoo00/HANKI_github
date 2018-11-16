package com.hanki.hanki;

import com.hanki.hanki.LikeShop.TestData;
import com.hanki.hanki.Main.ShopData;

import junit.framework.Test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkService {
    //테스트용
    @HTTP(method = "GET", path = "/HANKI/phone/test")
    Call<TestData> getTestResponse();
}

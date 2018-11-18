package com.hanki.hanki;

import com.hanki.hanki.Main.ShopName;
import com.hanki.hanki.NumberTicket.TestData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService {
    //테스트용
    @GET("/HANKI/phone/test")
    Call<TestData> getTestResponse();

    //매장명 조회
    @GET("/HANKI/shops")
    Call<ShopName> getShopNameResult(@Query("UUID") String UUID);
}

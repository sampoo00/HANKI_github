package com.hanki.hanki.Util;

import com.hanki.hanki.Main.ShopName;
import com.hanki.hanki.NumberTicket.TestData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {
    //테스트용
    @GET("/HANKI/phone/test")
    Call<TestData> getTestResponse();

    //매장명 조회 (baseUrl : http://117.17.156.101:8180/HANKI/shops)
    @GET("/HANKI/shops")
    Call<ShopName> getShopNameResult(@Query("UUID") String UUID);

    //매장명 조회 (tempUrl)
    //@GET("/aaaa/shops")
    //Call<ShopName> getShopNameResult(@Query("UUID") String UUID);
}

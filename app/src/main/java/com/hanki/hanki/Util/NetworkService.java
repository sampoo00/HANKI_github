package com.hanki.hanki.Util;

import com.hanki.hanki.Main.ShopName;
import com.hanki.hanki.ShopOrder.NetworkItem.ShopResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

    //매장명 조회 (baseUrl : http://117.17.156.101:8180/HANKI/shops)
//    @GET("/HANKI/shops")
//    Call<ShopName> getShopNameResult(@Query("UUID") String UUID);

    //매장명 조회 (tempUrl : http://192.168.1.108:8080/)
    @GET("/aaaa/shops")
    Call<ShopName> getShopNameResult(@Query("UUID") String UUID);

    //메뉴판 조회
    @GET("/aaaa/shops/menuInfo")
    Call<ShopResult> getShopMenuResult(@Query("UUID") String UUID, @Query("userId") String userId);
}

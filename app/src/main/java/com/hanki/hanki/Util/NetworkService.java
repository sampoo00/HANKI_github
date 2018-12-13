package com.hanki.hanki.Util;

import android.view.Menu;

import com.hanki.hanki.Main.ShopLogo;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.ShopOrder.NetworkItem.ShopResult;
import com.hanki.hanki.ShopOrder.NetworkItem.ToppingData;
import com.hanki.hanki.ShopOrder.NetworkItem.ToppingResult;
import com.hanki.hanki.ShopOrder.ShopInfo.InfoResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

    //매장명 조회 (baseUrl : http://117.17.156.101:8180/HANKI/shops)
    @GET("/HANKI/shops")
    Call<ShopLogo> getShopNameResult(@Query("UUID") String UUID);

    //메뉴판 조회
    @GET("/HANKI/shops/menuInfo")
    Call<ShopResult> getShopMenuResult(@Query("UUID") String UUID, @Query("userId") String userId);

    //필수 메뉴/선택 메뉴 조회
    @GET("/HANKI/shops/topping")
    Call<ToppingResult> getToppingResult(@Query("toppingKey") String toppingKey);

    //매장정보 조회
    @GET("/HANKI/shops/shopInfo")
    Call<InfoResult> getShopInfoResult(@Query("UUID") String UUID);
}

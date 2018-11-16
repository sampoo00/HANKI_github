package com.hanki.hanki;

import com.hanki.hanki.NumberTicket.TestData;

import retrofit2.Call;
import retrofit2.http.HTTP;

public interface NetworkService {
    //테스트용
    @HTTP(method = "GET", path = "/HANKI/phone/test")
    Call<TestData> getTestResponse();
}

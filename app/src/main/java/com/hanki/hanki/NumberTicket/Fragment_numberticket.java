package com.hanki.hanki.NumberTicket;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hanki.hanki.Main.ShopName;
import com.hanki.hanki.Util.Application;
import com.hanki.hanki.Util.NetworkService;
import com.hanki.hanki.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_numberticket extends Fragment {

    Button testBtn;
    TextView testTv;

    NetworkService networkService;

    public Fragment_numberticket() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_numberticket, container, false);
        testBtn = view.findViewById(R.id.testBtn);
        testTv = view.findViewById(R.id.textTv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                networkService = Application.getInstance().getNetworkService();
                /*
                Call<TestData> request1 = networkService.getTestResponse();
                request1.enqueue(new Callback<TestData>() {
                    @Override
                    public void onResponse(Call<TestData> call, Response<TestData> response) {
                        Log.d("응답", response.body().result);
                        if(response.isSuccessful()) {
                            TestData testData = response.body();
                            testTv.setText(testData.result);
                        }
                    }

                    @Override
                    public void onFailure(Call<TestData> call, Throwable t) {
                        testTv.setText(t.getMessage());
                    }
                });
                */

                Call<ShopName> request = networkService.getShopNameResult("15282");
                request.enqueue(new Callback<ShopName>() {
                    @Override
                    public void onResponse(Call<ShopName> call, Response<ShopName> response) {
                        Log.d("NumberTicket", response.code()+"");
                        if(response.isSuccessful()) {
                            ShopName shopName = response.body();
                            testTv.setText(shopName.toString());
                            Log.d("NumberTicket", shopName.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ShopName> call, Throwable t) {
                        testTv.setText(t.getMessage());
                    }
                });
            }
        });
    }
}

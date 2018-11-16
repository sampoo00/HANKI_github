package com.hanki.hanki.LikeShop;

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

import com.hanki.hanki.Application;
import com.hanki.hanki.NetworkService;
import com.hanki.hanki.R;

import junit.framework.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Fragment_LikeShop extends Fragment {

    Button testBtn;
    TextView testTv;

    NetworkService networkService;

    public Fragment_LikeShop() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_likeshop, container, false);
        testBtn = view.findViewById(R.id.testBtn);
        testTv = view.findViewById(R.id.textTv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl("http://117.17.156.101:8180/")
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
//        networkService = retrofit.create(NetworkService.class);

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                networkService = Application.getInstance().getNetworkService();
                Call<TestData> request = networkService.getTestResponse();
                request.enqueue(new Callback<TestData>() {
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
            }
        });
    }
}

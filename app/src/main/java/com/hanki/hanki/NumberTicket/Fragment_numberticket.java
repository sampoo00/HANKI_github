package com.hanki.hanki.NumberTicket;

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

import com.hanki.hanki.ShopOrder.NetworkItem.ShopResult;
import com.hanki.hanki.ShopOrder.NetworkItem.ShopTopInfo;
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

    public final static String TAG = "NUMBER_TICKET";

    public Fragment_numberticket() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_numberticket, container, false);
        testBtn = view.findViewById(R.id.testBtn);
        testTv = view.findViewById(R.id.textTv);

        networkService = Application.getInstance().getNetworkService();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UUID = "15290"; //UUID
                String userId = ""; //userId 설정

                //메뉴판 받아오기
                Call<ShopResult> request = networkService.getShopMenuResult(UUID, userId);
                request.enqueue(new Callback<ShopResult>() {
                    @Override
                    public void onResponse(Call<ShopResult> call, Response<ShopResult> response) {
                        if (response.isSuccessful()) {
                            ShopResult shopResult = response.body();
                            ShopTopInfo shopTopInfo = shopResult.result;
                            testTv.setText(shopTopInfo.toString());
                            Log.d(TAG, "RESPONSE " + response.code());
                        }
                    }
                    @Override
                    public void onFailure(Call<ShopResult> call, Throwable t) {
                        testTv.setText(t.getMessage());
                        Log.d(TAG, "FAIL " + t.getMessage());
                    }
                });
            }
        });
    }
}

package com.hanki.hanki.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hanki.hanki.HomeActivity;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMainActivity;

public class Fragment_Home extends Fragment {


    public Fragment_Home() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button shopMainBtn = (Button) view.findViewById(R.id.shopMainBtn); // 지워야할 것 test용
        shopMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.shopMainBtn:
                        Intent intent = new Intent(getActivity(), ShopMainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }



}

package com.hanki.hanki.NearByShop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanki.hanki.R;

import java.util.ArrayList;

public class Fragment_NearByShop extends Fragment {

    RecyclerView nearbyshop_recyclerview;

    public Fragment_NearByShop() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_nearbyshop, container, false);
        nearbyshop_recyclerview = (RecyclerView) view.findViewById(R.id.nearbyshop_recyclerview);

        TextView nearbyshop_infoMessage = (TextView)view.findViewById(R.id.nearbyshop_infoMessage);
        nearbyshop_infoMessage.setFocusableInTouchMode(true);
        nearbyshop_infoMessage.requestFocus();
        
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<NearbyShop> nearbyShopList = new ArrayList<>();
        NearbyShop nearbyShop;
        for(int i=0; i<7; i++) {
            nearbyShop = new NearbyShop("1", "교촌치킨 서초점",
                    "http://t1.daumcdn.net/news/201603/29/KorMedi/20160329083404634awxu.jpg",
                    4, 35, "허니콤보, 레드콤보", 1);
            nearbyShopList.add(nearbyShop);
        }

        nearbyshop_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        NearbyShopAdapter nearbyShopAdapter = new NearbyShopAdapter(getContext(), nearbyShopList);
        nearbyshop_recyclerview.setAdapter(nearbyShopAdapter);
    }
}

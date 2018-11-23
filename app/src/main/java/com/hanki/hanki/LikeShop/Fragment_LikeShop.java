package com.hanki.hanki.LikeShop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanki.hanki.R;

import java.util.ArrayList;

public class Fragment_LikeShop extends Fragment {

    RecyclerView likeshop_recyclerview;

    public Fragment_LikeShop() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_likeshop, container, false);
        likeshop_recyclerview = (RecyclerView) view.findViewById(R.id.likeshop_recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<LikeShop> likeShopList = new ArrayList<>();
        LikeShop likeShop;
        for(int i=0; i<7; i++) {
            likeShop = new LikeShop("15290", "파스타하우스",
                    "https://i0.wp.com/dilite.co.kr/wp-content/uploads/2018/04/%ED%8C%8C%EC%8A%A4%ED%83%80.jpg?fit=800505",
                    3, 150, "알리오올리오, 빠네", 1);
            likeShopList.add(likeShop);
        }

        likeshop_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        LikeShopAdapter likeShopAdapter = new LikeShopAdapter(getContext(), likeShopList);
        likeshop_recyclerview.setAdapter(likeShopAdapter);
    }
}

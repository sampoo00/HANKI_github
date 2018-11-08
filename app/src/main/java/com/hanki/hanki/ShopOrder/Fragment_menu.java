package com.hanki.hanki.ShopOrder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanki.hanki.R;

import java.util.ArrayList;


public class Fragment_menu extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private Fragment_menu_Adapter mMenuAdapter;
    private ArrayList<String[]> menuArrayList;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.shopMain_menu_recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(view.getContext());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        menuArrayList = new ArrayList<String[]>();
        menuArrayList.add(new String[]{"짜장면", "1000원"});
        menuArrayList.add(new String[]{"국수", "6000원"});
        menuArrayList.add(new String[]{"배고파", "100원"});
        menuArrayList.add(new String[]{"짜장면", "1000원"});
        menuArrayList.add(new String[]{"국수", "6000원"});
        menuArrayList.add(new String[]{"배고파", "100원"});
        menuArrayList.add(new String[]{"짜장면", "1000원"});
        menuArrayList.add(new String[]{"국수", "6000원"});
        menuArrayList.add(new String[]{"배고파", "100원"});
        menuArrayList.add(new String[]{"짜장면", "1000원"});
        menuArrayList.add(new String[]{"국수", "6000원"});
        menuArrayList.add(new String[]{"배고파", "100원"});


        mMenuAdapter = new Fragment_menu_Adapter(getContext(), menuArrayList);

        mRecyclerView.setAdapter(mMenuAdapter);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.shop_main_fragment_menu, container, false);
    }


}

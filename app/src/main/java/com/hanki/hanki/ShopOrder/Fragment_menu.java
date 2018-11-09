package com.hanki.hanki.ShopOrder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.hanki.hanki.R;

import java.util.ArrayList;


public class Fragment_menu extends Fragment {

    private RecyclerView mMenuRecyclerView;
    private LinearLayoutManager mMenuLinearLayoutManager;
    private Fragment_menu_Adapter mMenuAdapter;
    private ArrayList<String[]> menuArrayList;

    private RecyclerView mMenuRecRecyclerView;
    private GridLayoutManager mMenuRecGridLayoutManager;
    private Fragment_menu_rec_Adapter mMenuRecAdapter;
    private ArrayList<String[]> menuRecArrayList;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initMenuRecyclerView(view);
        
    }

    public void initMenuRecyclerView(View view){
        mMenuRecyclerView = view.findViewById(R.id.shopMain_menu_recyclerView);
        mMenuRecRecyclerView = view.findViewById(R.id.shopMain_menu_rec_recyclerView);

        mMenuLinearLayoutManager = new LinearLayoutManager(view.getContext());
        mMenuLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMenuRecGridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mMenuRecGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);


        mMenuRecyclerView.setLayoutManager(mMenuLinearLayoutManager);
        mMenuRecyclerView.setHasFixedSize(true);
        mMenuRecRecyclerView.setLayoutManager(mMenuRecGridLayoutManager);
        mMenuRecRecyclerView.setHasFixedSize(true);

        initMenuArrayList();

        mMenuRecAdapter = new Fragment_menu_rec_Adapter(getContext(), menuRecArrayList);
        mMenuRecRecyclerView.setAdapter(mMenuRecAdapter);
        mMenuAdapter = new Fragment_menu_Adapter(getContext(), menuArrayList);
        mMenuRecyclerView.setAdapter(mMenuAdapter);


    }

    public void initMenuArrayList(){
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

        menuRecArrayList = new ArrayList<String[]>();
        menuRecArrayList.add(new String[]{"매운탕", "6000원"});
        menuRecArrayList.add(new String[]{"회", "10000원"});
        menuRecArrayList.add(new String[]{"짜장곱배기", "16000원"});
        menuRecArrayList.add(new String[]{"탕수육", "30000원"});
        menuRecArrayList.add(new String[]{"매운탕45", "46000원"});

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.shop_main_fragment_menu, container, false);
    }


}

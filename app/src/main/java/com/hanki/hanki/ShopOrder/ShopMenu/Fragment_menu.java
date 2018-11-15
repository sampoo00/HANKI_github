package com.hanki.hanki.ShopOrder.ShopMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanki.hanki.R;

import java.util.ArrayList;


public class Fragment_menu extends Fragment {

    //강조하고 싶은 메뉴
    private RecyclerView mMenuRecyclerView;
    private LinearLayoutManager mMenuLinearLayoutManager;
    private ShopMenuAdapter mMenuAdapter;
    private ArrayList<String[]> menuArrayList;

    //매장 메뉴
    private RecyclerView mMenuRecRecyclerView;
    private GridLayoutManager mMenuRecGridLayoutManager;
    private ShopMenuRecAdapter mMenuRecAdapter;
    private ArrayList<String[]> menuRecArrayList;

    //원산지 표기
    TextView txtCountryOrigin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.shop_main_fragment_menu, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        initMenuRecyclerView(view);


    }

    public void init(View view){

        txtCountryOrigin = (TextView)view.findViewById(R.id.shopMain_countryOforigin);
        txtCountryOrigin.setText("소고기(호주산), 돼지고기(국내산), 닭고기(국내산), 김치(국내산), 쌀(국내산)");
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

        mMenuRecAdapter = new ShopMenuRecAdapter(getContext(), menuRecArrayList);
        mMenuRecRecyclerView.setAdapter(mMenuRecAdapter);
        mMenuAdapter = new ShopMenuAdapter(getContext(), menuArrayList);
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



}

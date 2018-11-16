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
import java.util.Arrays;
import java.util.List;


public class Fragment_menu extends Fragment {

    //강조하고 싶은 메뉴
    private RecyclerView mMenuRecyclerView;
    private LinearLayoutManager mMenuLinearLayoutManager;
    private ShopMenuAdapter mMenuAdapter;
    private List<ShopMenuData> mMenuList;

    //매장 메뉴
    private RecyclerView mMenuRecRecyclerView;
    private GridLayoutManager mMenuRecGridLayoutManager;
    private ShopMenuRecAdapter mMenuRecAdapter;
    private List<ShopRecMenuData> mMenuRecList;

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

        mMenuRecAdapter = new ShopMenuRecAdapter(getContext(), mMenuRecList);
        mMenuRecRecyclerView.setAdapter(mMenuRecAdapter);
        mMenuAdapter = new ShopMenuAdapter(getContext(), mMenuList);
        mMenuRecyclerView.setAdapter(mMenuAdapter);


    }

    public void initMenuArrayList(){

        mMenuList = Arrays.asList(new ShopMenuData("국수", 140020),
                new ShopMenuData("국수2", 1403000),
                new ShopMenuData("국수3", 1200),
                new ShopMenuData("국수4", 1039439),
                new ShopMenuData("국수5", 14000),
                new ShopMenuData("국수6", 1403000),
                new ShopMenuData("국수7", 1200));

        mMenuRecList = Arrays.asList(new ShopRecMenuData("부대찌게", 14000),
                new ShopRecMenuData("된장찌게", 1403000),
                new ShopRecMenuData("칼국수", 1200),
                new ShopRecMenuData("게찌게", 1039439),
                new ShopRecMenuData("부대찌게", 14000),
                new ShopRecMenuData("된장찌게", 1403000),
                new ShopRecMenuData("칼국수", 1200));

    }



}

package com.hanki.hanki.ShopOrder.ShopMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Fragment_menu extends Fragment {

    //강조하고 싶은 메뉴
    private RecyclerView mMenuRecyclerView;
    private LinearLayoutManager mMenuLinearLayoutManager;
    private ShopSubMenuAdapter mMenuAdapter;
    private List<ShopSubMenuData> mMenuList;

    //매장 메뉴
    private RecyclerView mMenuRecRecyclerView;
    private GridLayoutManager mMenuRecGridLayoutManager;
    private ShopMainMenuAdapter mMenuRecAdapter;
    private List<ShopMainMenuData> mMenuRecList;

    String origin; //원산지 표기
    ArrayList<MenuData> menuList;

    public static final String TAG = "MENU";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_main_fragment_menu, container, false);

        //ShopMainActivity에서 넘겨준 원산지(origin), 메뉴리스트(menuList) 받기
        Bundle bundle = getArguments();
        origin = bundle.getString("origin");
        menuList = bundle.getParcelableArrayList("menuList");
        Log.d(TAG, "menu List 사이즈 " + menuList.size());
        Log.d(TAG, "menu List 값 " + menuList.toString());
        Log.d(TAG, "원산지 " + origin);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        initMenuRecyclerView(view);
    }

    public void init(View view) {

        //원산지 표시
        TextView txtCountryOrigin = (TextView) view.findViewById(R.id.shopMain_countryOforigin);
        if(origin != null) {
            txtCountryOrigin.setText(origin);
        }
    }

    public void initMenuRecyclerView(View view) {
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

        mMenuRecAdapter = new ShopMainMenuAdapter(getContext(), mMenuRecList);
        mMenuRecRecyclerView.setAdapter(mMenuRecAdapter);
        mMenuAdapter = new ShopSubMenuAdapter(getContext(), mMenuList);
        mMenuRecyclerView.setAdapter(mMenuAdapter);
    }

    public void initMenuArrayList() {
        mMenuList = Arrays.asList(new ShopSubMenuData("국수", 140020),
                new ShopSubMenuData("국수2", 1403000),
                new ShopSubMenuData("국수3", 1200),
                new ShopSubMenuData("국수4", 1039439),
                new ShopSubMenuData("국수5", 14000),
                new ShopSubMenuData("국수6", 1403000),
                new ShopSubMenuData("국수7", 1200));

        mMenuRecList = Arrays.asList(new ShopMainMenuData("부대찌게", 14000),
                new ShopMainMenuData("된장찌게", 1403000),
                new ShopMainMenuData("칼국수", 1200),
                new ShopMainMenuData("게찌게", 1039439),
                new ShopMainMenuData("부대찌게", 14000),
                new ShopMainMenuData("된장찌게", 1403000),
                new ShopMainMenuData("칼국수", 1200));
    }

}

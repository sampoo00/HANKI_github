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
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.ShopOrder.NetworkItem.ShopTopInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fragment_menu extends Fragment {

    //메인메뉴
    private RecyclerView mMainMenuRecyclerView;
    private GridLayoutManager mMainMenuGridLayoutManager;
    private ShopMainMenuAdapter mMainMenuAdapter;
    private List<MenuData> mMainMenuList;

    //서브메뉴
    private RecyclerView mSubMenuRecyclerView;
    private LinearLayoutManager mSubMenuLinearLayoutManager;
    private ShopSubMenuAdapter mSubMenuAdapter;
    private List<MenuData> mSubMenuList;

    ShopTopInfo shopTopInfo;

    public static final String TAG = "MENU";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_main_fragment_menu, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ShopMainActivity에서 넘겨준 shopTopInfo 받기
        Bundle bundle = getArguments();
        shopTopInfo = (ShopTopInfo) bundle.getParcelable("shopTopInfo");

        init(view);
        initMenuRecyclerView(view);
    }

    public void init(View view) {
        //원산지 표시
        TextView txtCountryOrigin = (TextView) view.findViewById(R.id.shopMain_countryOforigin);
        String origin = shopTopInfo.origin;
        txtCountryOrigin.setText(origin);

        mMainMenuList = new ArrayList<>();
        mSubMenuList = new ArrayList<>();
    }

    public void initMenuRecyclerView(View view) {
        mMainMenuRecyclerView = view.findViewById(R.id.shopMain_main_menu_recyclerView);
        mSubMenuRecyclerView = view.findViewById(R.id.shopMain_sub_menu_recyclerView);

        mMainMenuGridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mMainMenuGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mMainMenuRecyclerView.setLayoutManager(mMainMenuGridLayoutManager);
        mMainMenuRecyclerView.setHasFixedSize(true);

        mSubMenuLinearLayoutManager = new LinearLayoutManager(view.getContext());
        mSubMenuLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSubMenuRecyclerView.setLayoutManager(mSubMenuLinearLayoutManager);
        mSubMenuRecyclerView.setHasFixedSize(true);

        initMenuArrayList();

        mMainMenuAdapter = new ShopMainMenuAdapter(getContext(), mMainMenuList, shopTopInfo.shopCode); //메인메뉴
        mMainMenuRecyclerView.setAdapter(mMainMenuAdapter);
        mSubMenuAdapter = new ShopSubMenuAdapter(getContext(), mSubMenuList, shopTopInfo.shopCode); //서브메뉴
        mSubMenuRecyclerView.setAdapter(mSubMenuAdapter);
    }

    public void initMenuArrayList() {
        ArrayList<MenuData> menuList = shopTopInfo.list; //매장 메뉴리스트
        if (shopTopInfo.list != null) {
            if (menuList.size() != 0) {
                for (int i = 0; i < menuList.size(); i++) {
                    if (menuList.get(i).getCategory().equals("main")) { //카테고리가 main인 menuList 구성
                        mMainMenuList.add(menuList.get(i));
                    } else if (menuList.get(i).getCategory().equals("sub")) { //카테고리가 sub인 menuList 구성
                        mSubMenuList.add(menuList.get(i));
                    }
                }
            }
        }

//        mMenuList = Arrays.asList(new ShopSubMenuData("국수", 140020),
//                new ShopSubMenuData("국수2", 1403000),
//                new ShopSubMenuData("국수3", 1200),
//                new ShopSubMenuData("국수4", 1039439),
//                new ShopSubMenuData("국수5", 14000),
//                new ShopSubMenuData("국수6", 1403000),
//                new ShopSubMenuData("국수7", 1200));
//
//        mMenuRecList = Arrays.asList(new ShopMainMenuData("부대찌게", 14000),
//                new ShopMainMenuData("된장찌게", 1403000),
//                new ShopMainMenuData("칼국수", 1200),
//                new ShopMainMenuData("게찌게", 1039439),
//                new ShopMainMenuData("부대찌게", 14000),
//                new ShopMainMenuData("된장찌게", 1403000),
//                new ShopMainMenuData("칼국수", 1200));
    }
}

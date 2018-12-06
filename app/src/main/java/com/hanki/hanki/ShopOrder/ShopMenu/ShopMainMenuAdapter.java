package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.ShopOrder.ShopMainActivity;
import com.hanki.hanki.Util.Application;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShopMainMenuAdapter extends RecyclerView.Adapter<ShopMenuViewHolder>  {

    private Context context;
    private ArrayList<MenuData> mainMenuData;
    private String shopCode;


    public ShopMainMenuAdapter(Context context, ArrayList<MenuData> mainMenuData, String shopCode) {
        this.context = context;
        this.mainMenuData = mainMenuData;
        this.shopCode = shopCode;
    }

    public void setAdapter(ArrayList<MenuData> mainMenuData) {
        this.mainMenuData = mainMenuData;
        notifyDataSetChanged();
    }

    @Override
    public ShopMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_menu_mian_menu_recycler, parent, false);
        ShopMenuViewHolder shopMenu_viewHolder = new ShopMenuViewHolder(view);

        return shopMenu_viewHolder;
    }

//    public static Fragment_menu newInstance(ArrayList<MenuData> mainMenuData) {
//        Fragment_menu fragment = new Fragment_menu();
//        Bundle args = new Bundle();
//        args.putParcelable(SelectedMenuData, (Parcelable) mainMenuData);
//        fragment.setArguments(args);
//        return fragment;
//    }

    //shopDialog 호출
    public void goShopMenuOrder(MenuData menuData){
        ShopMenuDialog shopMenuDialog = new ShopMenuDialog(context, menuData, shopCode);
        shopMenuDialog.setCanceledOnTouchOutside(false);
        shopMenuDialog.show();
    }

    //천 단위 숫자 입력
    public static String moneyFormat(int inputMoney) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return decimalFormat.format(inputMoney);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ShopMenuViewHolder holder, final int position) {
        String imageUrl = Application.getInstance().imageUrl + "menu/"
                + shopCode + "/" + mainMenuData.get(position).getMenuImgId();
        Glide.with(context).load(imageUrl).into(holder.VH_menu_main_image);
        Log.d("MAIN_MENU_ADAPTER", "IMAGE_URL : " + imageUrl);

        holder.VH_menu_main_title.setText(mainMenuData.get(position).getMenuName());
        holder.VH_menu_main_fee.setText(String.valueOf(moneyFormat(mainMenuData.get(position).getMenuPrice()))+"원");
        holder.VH_menu_main_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //POP_UP 만들기

//                Toast.makeText(context, "이미지 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder(mainMenuData.get(position));
            }
        });

        holder.VH_menu_main_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "타이틀 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder(mainMenuData.get(position));

            }
        });

        holder.VH_menu_main_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "가격 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder(mainMenuData.get(position));

            }
        });

        holder.VH_menu_main_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "LinearLayout1클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder(mainMenuData.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mainMenuData != null ? mainMenuData.size() : 0;
    }

}

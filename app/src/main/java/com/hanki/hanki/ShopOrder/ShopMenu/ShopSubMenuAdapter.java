package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.Util.Application;

import java.text.DecimalFormat;
import java.util.List;

public class ShopSubMenuAdapter extends RecyclerView.Adapter<ShopMenuViewHolder>  {

    private Context context;
    private List<MenuData> subMenuData;
    private String shopCode;

    public ShopSubMenuAdapter(Context context, List<MenuData> subMenuData, String shopCode) {
        this.context = context;
        this.subMenuData = subMenuData;
        this.shopCode = shopCode;
    }

    public void setAdapter(List<MenuData> subMenuData) {
        this.subMenuData = subMenuData;
        notifyDataSetChanged();
    }

    @Override
    public ShopMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_menu_menulist_recycler, parent, false);
        ShopMenuViewHolder shopMenu_viewHolder = new ShopMenuViewHolder(view);

        return shopMenu_viewHolder;
    }

    public void goShopMenuOrder(){
        ShopMenuDialog shopMenuDialog = new ShopMenuDialog(context);
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
    public void onBindViewHolder(ShopMenuViewHolder holder, int position) {
        String imageUrl = Application.getInstance().imageUrl + "menu/"
                + shopCode + "/" + subMenuData.get(position).getMenuImgId();
        Glide.with(context).load(imageUrl).into(holder.VH_menu_image);

        holder.VH_menu_title.setText(subMenuData.get(position).getMenuName());
        holder.VH_menu_fee.setText(String.valueOf(moneyFormat(subMenuData.get(position).getMenuPrice()))+"원");

        holder.VH_menu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //POP_UP 만들기
                //Toast.makeText(context, "이미지 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();
            }
        });

        holder.VH_menu_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "타이틀 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();

            }
        });

        holder.VH_menu_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "가격 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();
            }
        });

        holder.VH_menu_recyclerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "relativeLayout클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();
            }
        });    }

    @Override
    public int getItemCount() {
        return subMenuData != null ? subMenuData.size() : 0;
    }

}

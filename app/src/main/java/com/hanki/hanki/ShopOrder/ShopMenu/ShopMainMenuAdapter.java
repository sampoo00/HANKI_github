package com.hanki.hanki.ShopOrder.ShopMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.Util.Application;

import java.text.DecimalFormat;
import java.util.List;

public class ShopMainMenuAdapter extends RecyclerView.Adapter<ShopMenuViewHolder>  {

    private Context context;
    private List<MenuData> mainMenuData;
    private String shopCode;

    public ShopMainMenuAdapter(Context context, List<MenuData> mainMenuData, String shopCode) {
        this.context = context;
        this.mainMenuData = mainMenuData;
        this.shopCode = shopCode;
    }

    public void setAdapter(List<MenuData> mainMenuData) {
        this.mainMenuData = mainMenuData;
        notifyDataSetChanged();
    }

    @Override
    public ShopMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_menu_recmenu_recycler, parent, false);
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

    @Override
    public void onBindViewHolder(ShopMenuViewHolder holder, int position) {
        String imageUrl = Application.getInstance().imageUrl + "menu/"
                + shopCode + "/" + mainMenuData.get(position).getMenuImgId();
        Glide.with(context).load(imageUrl).into(holder.VH_menu_rec_image);
        Log.d("MAIN_MENU_ADAPTER", "IMAGE_URL : " + imageUrl);

        holder.VH_menu_rec_title.setText(mainMenuData.get(position).getMenuName());
        holder.VH_menu_rec_fee.setText(String.valueOf(moneyFormat(mainMenuData.get(position).getMenuPrice()))+"원");
        holder.VH_menu_rec_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //POP_UP 만들기

//                Toast.makeText(context, "이미지 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();
            }
        });

        holder.VH_menu_rec_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "타이틀 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();

            }
        });

        holder.VH_menu_rec_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "가격 클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();

            }
        });

        holder.VH_menu_rec_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
//                Toast.makeText(context, "LinearLayout1클릭", Toast.LENGTH_LONG).show();
                goShopMenuOrder();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mainMenuData != null ? mainMenuData.size() : 0;
    }

}

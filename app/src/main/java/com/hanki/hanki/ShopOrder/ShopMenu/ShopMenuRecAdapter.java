package com.hanki.hanki.ShopOrder.ShopMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;

import java.util.ArrayList;

public class ShopMenuRecAdapter extends RecyclerView.Adapter<ShopMenuViewHolder>  {
    private Context context;
    private ArrayList<String[]> menuRecData;

    public ShopMenuRecAdapter(Context context, ArrayList<String[]> menuRecData) {
        this.context = context;
        this.menuRecData = menuRecData;
    }

    public void setAdapter(ArrayList<String[]> menuRecData) {
        this.menuRecData = menuRecData;
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

    @Override
    public void onBindViewHolder(ShopMenuViewHolder holder, int position) {


        Glide.with(context)
                .load(R.drawable.logo_sample)
                .into(holder.VH_menu_rec_image);
        holder.VH_menu_rec_title.setText(menuRecData.get(position)[0]);
        holder.VH_menu_rec_fee.setText(menuRecData.get(position)[1]);



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
        return menuRecData != null ? menuRecData.size() : 0;
    }

}

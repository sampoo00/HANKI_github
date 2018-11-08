package com.hanki.hanki.ShopOrder;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.hanki.hanki.R;

import java.util.ArrayList;

public class Fragment_menu_Adapter extends RecyclerView.Adapter<Fragment_menu_ViewHolder>  {
    private Context context;
    private ArrayList<String[]> menuData;

    public Fragment_menu_Adapter(Context context, ArrayList<String[]> menuData) {
        this.context = context;
        this.menuData = menuData;
    }

    public void setAdapter(ArrayList<String[]> menuData) {
        this.menuData = menuData;
        notifyDataSetChanged();
    }

    @Override
    public Fragment_menu_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_main_item_menu_recycler, parent, false);
        Fragment_menu_ViewHolder fragment_menu_viewHolder = new Fragment_menu_ViewHolder(view);

        return fragment_menu_viewHolder;
    }

    @Override
    public void onBindViewHolder(Fragment_menu_ViewHolder holder, int position) {


        Glide.with(context)
                .load(R.drawable.logo_sample)
                .into(holder.VH_menu_image);

        holder.VH_menu_title.setText(menuData.get(position)[0]);
        holder.VH_menu_fee.setText(menuData.get(position)[1]);

        holder.VH_menu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //POP_UP 만들기

                Toast.makeText(context, "이미지 클릭", Toast.LENGTH_LONG).show();

            }
        });

        holder.VH_menu_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
                Toast.makeText(context, "타이틀 클릭", Toast.LENGTH_LONG).show();

            }
        });

        holder.VH_menu_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
                Toast.makeText(context, "가격 클릭", Toast.LENGTH_LONG).show();

            }
        });

        holder.VH_menu_recyclerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popup
                Toast.makeText(context, "relativeLayout클릭", Toast.LENGTH_LONG).show();

            }
        });    }

    @Override
    public int getItemCount() {
        return menuData != null ? menuData.size() : 0;
    }

}

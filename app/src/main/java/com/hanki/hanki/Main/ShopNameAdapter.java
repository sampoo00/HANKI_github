package com.hanki.hanki.Main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMainActivity;

import java.util.ArrayList;

public class ShopNameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ShopName> shopLogoList;

    public ShopNameAdapter(Context context, ArrayList<ShopName> shopLogoList) {
        this.context = context;
        this.shopLogoList = shopLogoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_shop_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Glide.with(context).load(shopLogoList.get(position).getShopImgUrl())
                .into(myViewHolder.shopLogo);
        myViewHolder.shopName.setText(shopLogoList.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return shopLogoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView shopLogo;
        TextView shopName;

        public MyViewHolder(final View itemView) {
            super(itemView);
            shopLogo = (ImageView) itemView.findViewById(R.id.shopLogo);
            shopName = (TextView) itemView.findViewById(R.id.shopName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ShopMainActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}

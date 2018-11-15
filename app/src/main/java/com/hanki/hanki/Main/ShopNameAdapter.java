package com.hanki.hanki.Main;

import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanki.hanki.NetworkService;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMainActivity;

import java.util.ArrayList;

import retrofit2.Call;

public class ShopNameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ShopData> shopNameList;

    public ShopNameAdapter(ArrayList<ShopData> shopNameList) {
        this.shopNameList = shopNameList;
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
        myViewHolder.shopTv.setText(shopNameList.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return shopNameList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView shopTv;

        public MyViewHolder(final View itemView) {
            super(itemView);
            shopTv = (TextView) itemView.findViewById(R.id.shopTv);

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

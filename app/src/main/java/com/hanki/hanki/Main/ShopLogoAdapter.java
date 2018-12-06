package com.hanki.hanki.Main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMainActivity;
import com.hanki.hanki.Util.Application;

import java.util.ArrayList;

public class ShopLogoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ShopLogo> shopLogoList;

    public static final String TAG = "SHOP_NAME_ADAPTER";

    public ShopLogoAdapter(Context context, ArrayList<ShopLogo> shopLogoList) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        //이미지 URL 생성
        String shopLogoUrl  = Application.getInstance().imageUrl + "shop/textLogo/"
                + shopLogoList.get(position).getShopCode() + "/" + shopLogoList.get(position).getTextImgId();
        Glide.with(context).load(shopLogoUrl).into(myViewHolder.shopLogo); //이미지 띄우기

        Log.d(TAG, shopLogoUrl); //이미지 경로 확인하기

        //ShopMainActivity로 이동 시 UUID, userId를 같이 넘겨줌
        ((MyViewHolder) holder).shopLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShopMainActivity.class);
                intent.putExtra("UUID", shopLogoList.get(position).getUUID());
                intent.putExtra("userId", "");
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopLogoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView shopLogo;

        public MyViewHolder(final View itemView) {
            super(itemView);
            shopLogo = (ImageView) itemView.findViewById(R.id.shopLogo);
        }
    }
}

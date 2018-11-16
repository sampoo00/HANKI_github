package com.hanki.hanki.LikeShop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.NearByShop.NearbyShopAdapter;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMainActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LikeShopAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    Context context;
    ArrayList<LikeShop> likeShopList;

    public LikeShopAdapter(Context context, ArrayList<LikeShop> likeShopList) {
        this.context = context;
        this.likeShopList = likeShopList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_likeshop_item, parent, false);
        return new LikeShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LikeShopAdapter.LikeShopViewHolder viewHolder = (LikeShopAdapter.LikeShopViewHolder) holder;
        Glide.with(context).load(likeShopList.get(position).shopImage).into(viewHolder.likeshop_shopImage);
        viewHolder.likeshop_shopName.setText(likeShopList.get(position).shopName);
        viewHolder.likeshop_shopScore.setText(String.valueOf(likeShopList.get(position).shopScore));
        viewHolder.likeshop_reviewNum.setText(String.valueOf(likeShopList.get(position).reviewNum));
        viewHolder.likeshop_mainMenu.setText(likeShopList.get(position).mainMenu);
    }

    @Override
    public int getItemCount() {
        return likeShopList.size();
    }

    public class LikeShopViewHolder extends RecyclerView.ViewHolder {

        CircleImageView likeshop_shopImage;
        TextView likeshop_shopName;
        TextView likeshop_shopScore;
        TextView likeshop_reviewNum;
        TextView likeshop_mainMenu;

        public LikeShopViewHolder(View itemView) {
            super(itemView);

            likeshop_shopImage = (CircleImageView) itemView.findViewById(R.id.likeshop_shopImage);
            likeshop_shopName = (TextView) itemView.findViewById(R.id.likeshop_shopName);
            likeshop_shopScore = (TextView) itemView.findViewById(R.id.likeshop_shopScore);
            likeshop_reviewNum = (TextView) itemView.findViewById(R.id.likeshop_reviewNum);
            likeshop_mainMenu = (TextView) itemView.findViewById(R.id.likeshop_mainMenu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ShopMainActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

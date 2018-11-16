package com.hanki.hanki.NearByShop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMainActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NearbyShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<NearbyShop> nearbyShopList;

    public NearbyShopAdapter(Context context, ArrayList<NearbyShop> nearbyshopList) {
        this.context = context;
        this.nearbyShopList = nearbyshopList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_nearbyshop_item, parent, false);
        return new NearbyShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NearbyShopViewHolder viewHolder = (NearbyShopViewHolder) holder;
        Glide.with(context).load(nearbyShopList.get(position).shopImage).into(viewHolder.nearbyshop_shopImage);
        viewHolder.nearbyshop_shopName.setText(nearbyShopList.get(position).shopName);
        viewHolder.nearbyshop_shopScore.setText(String.valueOf(nearbyShopList.get(position).shopScore));
        viewHolder.nearbyshop_reviewNum.setText(String.valueOf(nearbyShopList.get(position).reviewNum));
        viewHolder.nearbyshop_mainMenu.setText(nearbyShopList.get(position).mainMenu);
    }

    @Override
    public int getItemCount() {
        return nearbyShopList.size();
    }

    private class NearbyShopViewHolder extends RecyclerView.ViewHolder {
        CircleImageView nearbyshop_shopImage;
        TextView nearbyshop_shopName;
        TextView nearbyshop_shopScore;
        TextView nearbyshop_reviewNum;
        TextView nearbyshop_mainMenu;

        public NearbyShopViewHolder(View itemView) {
            super(itemView);

            nearbyshop_shopImage = (CircleImageView) itemView.findViewById(R.id.nearbyshop_shopImage);
            nearbyshop_shopName = (TextView) itemView.findViewById(R.id.nearbyshop_shopName);
            nearbyshop_shopScore = (TextView) itemView.findViewById(R.id.nearbyshop_shopScore);
            nearbyshop_reviewNum = (TextView) itemView.findViewById(R.id.nearbyshop_reviewNum);
            nearbyshop_mainMenu = (TextView) itemView.findViewById(R.id.nearbyshop_mainMenu);

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

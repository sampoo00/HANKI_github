package com.hanki.hanki.FoodTray;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class FoodTrayOderListViewHolder extends RecyclerView.ViewHolder {
    //매장명, 버튼
    TextView VH_ShopName;
    ImageView VH_deleteBtn;



    public FoodTrayOderListViewHolder(View itemView) {
        super(itemView);
    }
}

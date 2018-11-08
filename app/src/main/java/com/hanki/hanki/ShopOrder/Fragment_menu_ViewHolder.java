package com.hanki.hanki.ShopOrder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanki.hanki.R;

public class Fragment_menu_ViewHolder extends RecyclerView.ViewHolder {

        public ImageView VH_menu_image;
        public TextView VH_menu_title;
        public TextView VH_menu_fee;
        public RelativeLayout VH_menu_recyclerLayout;

        public Fragment_menu_ViewHolder(View itemView) {
            super(itemView);

            VH_menu_image = (ImageView)itemView.findViewById(R.id.menu_recyclerImage);
            VH_menu_title = (TextView)itemView.findViewById(R.id.menu_recycler_title);
            VH_menu_fee = (TextView) itemView.findViewById(R.id.menu_recycler_fee);
            VH_menu_recyclerLayout = (RelativeLayout) itemView.findViewById(R.id.shopMain_menu_recyclerView_Layout);
        }
}


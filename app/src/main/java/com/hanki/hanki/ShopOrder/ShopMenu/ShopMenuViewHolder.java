package com.hanki.hanki.ShopOrder.ShopMenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanki.hanki.R;

public class ShopMenuViewHolder extends RecyclerView.ViewHolder {

        public ImageView VH_menu_sub_image;
        public TextView VH_menu_sub_title;
        public TextView VH_menu_sub_fee;
        public RelativeLayout VH_menu_sub_recyclerLayout;

        public ImageView VH_menu_main_image;
        public TextView VH_menu_main_title;
        public TextView VH_menu_main_fee;
        public LinearLayout VH_menu_main_linearLayout;


        public ShopMenuViewHolder(View itemView) {
            super(itemView);

            VH_menu_sub_image = (ImageView)itemView.findViewById(R.id.menu_sub_foodImage);
            VH_menu_sub_title = (TextView)itemView.findViewById(R.id.menu_sub_recycler_title);
            VH_menu_sub_fee = (TextView) itemView.findViewById(R.id.menu_sub_recycler_fee);
            VH_menu_sub_recyclerLayout = (RelativeLayout) itemView.findViewById(R.id.shopMain_menu_sub_recyclerLayout);

            VH_menu_main_image = (ImageView)itemView.findViewById(R.id.menu_main_recyclerImage1);
            VH_menu_main_title = (TextView)itemView.findViewById(R.id.menu_main_recycler_title1);
            VH_menu_main_fee = (TextView)itemView.findViewById(R.id.menu_main_recycler_fee1);
            VH_menu_main_linearLayout = (LinearLayout)itemView.findViewById(R.id.shopMain_menu_main_recyclerLayout1);

        }
}


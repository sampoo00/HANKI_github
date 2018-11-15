package com.hanki.hanki.ShopOrder.ShopMenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanki.hanki.R;

public class ShopMenuViewHolder extends RecyclerView.ViewHolder {

        public ImageView VH_menu_image;
        public TextView VH_menu_title;
        public TextView VH_menu_fee;
        public RelativeLayout VH_menu_recyclerLayout;

        public ImageView VH_menu_rec_image;
        public TextView VH_menu_rec_title;
        public TextView VH_menu_rec_fee;
        public LinearLayout VH_menu_rec_linearLayout;


        public ShopMenuViewHolder(View itemView) {
            super(itemView);

            VH_menu_image = (ImageView)itemView.findViewById(R.id.menu_recyclerImage);
            VH_menu_title = (TextView)itemView.findViewById(R.id.menu_recycler_title);
            VH_menu_fee = (TextView) itemView.findViewById(R.id.menu_recycler_fee);
            VH_menu_recyclerLayout = (RelativeLayout) itemView.findViewById(R.id.shopMain_menu_recyclerLayout);

            VH_menu_rec_image = (ImageView)itemView.findViewById(R.id.menu_rec_recyclerImage1);
            VH_menu_rec_title = (TextView)itemView.findViewById(R.id.menu_rec_recycler_title1);
            VH_menu_rec_fee = (TextView)itemView.findViewById(R.id.menu_rec_recycler_fee1);
            VH_menu_rec_linearLayout = (LinearLayout)itemView.findViewById(R.id.shopMain_menu_rec_recyclerLayout1);

        }
}


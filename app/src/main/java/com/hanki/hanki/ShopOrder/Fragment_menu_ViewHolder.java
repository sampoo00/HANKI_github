package com.hanki.hanki.ShopOrder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.hanki.hanki.R;

import org.w3c.dom.Text;

public class Fragment_menu_ViewHolder extends RecyclerView.ViewHolder {

        public ImageView VH_menu_image;
        public TextView VH_menu_title;
        public TextView VH_menu_fee;
        public RelativeLayout VH_menu_recyclerLayout;

        public ImageView VH_menu_rec_image1;
        public TextView VH_menu_rec_title1;
        public TextView VH_menu_rec_fee1;
        public LinearLayout VH_menu_rec_linearLayout1;

        public ImageView VH_menu_rec_image2;
        public TextView VH_menu_rec_title2;
        public TextView VH_menu_rec_fee2;
        public LinearLayout VH_menu_rec_linearLayout2;

        public Fragment_menu_ViewHolder(View itemView) {
            super(itemView);

            VH_menu_image = (ImageView)itemView.findViewById(R.id.menu_recyclerImage);
            VH_menu_title = (TextView)itemView.findViewById(R.id.menu_recycler_title);
            VH_menu_fee = (TextView) itemView.findViewById(R.id.menu_recycler_fee);
            VH_menu_recyclerLayout = (RelativeLayout) itemView.findViewById(R.id.shopMain_menu_recyclerLayout);

            VH_menu_rec_image1 = (ImageView)itemView.findViewById(R.id.menu_rec_recyclerImage1);
            VH_menu_rec_title1 = (TextView)itemView.findViewById(R.id.menu_rec_recycler_title1);
            VH_menu_rec_fee1 = (TextView)itemView.findViewById(R.id.menu_rec_recycler_fee1);
            VH_menu_rec_linearLayout1 = (LinearLayout)itemView.findViewById(R.id.shopMain_menu_rec_recyclerLayout1);

//            VH_menu_rec_image2 = (ImageView)itemView.findViewById(R.id.menu_rec_recyclerImage2);
//            VH_menu_rec_title2 = (TextView)itemView.findViewById(R.id.menu_rec_recycler_title2);
//            VH_menu_rec_fee2 = (TextView)itemView.findViewById(R.id.menu_rec_recycler_fee2);
//            VH_menu_rec_linearLayout2 = (LinearLayout)itemView.findViewById(R.id.shopMain_menu_rec_recyclerLayout2);
        }
}


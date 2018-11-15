package com.hanki.hanki.ShopOrder.ShopMenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hanki.hanki.R;

public class ShopReqMenuListViewHolder extends RecyclerView.ViewHolder {
    //필수 메뉴
    RadioButton VH_reqRadioBtn;
    TextView VH_menuSize;
    TextView VH_menuPeople;
    TextView VH_menuPrice;

    //선택 메뉴

    public ShopReqMenuListViewHolder(View itemView) {
        super(itemView);

        VH_reqRadioBtn = (RadioButton) itemView.findViewById(R.id.reqMenuRadioBtn);
        VH_menuSize = (TextView) itemView.findViewById(R.id.reqMenuSize);
        VH_menuPeople = (TextView) itemView.findViewById(R.id.reqMenuPeople);
        VH_menuPrice = (TextView) itemView.findViewById(R.id.reqMenuPrice);


    }
}

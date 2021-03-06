package com.hanki.hanki.ShopOrder.ShopMenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hanki.hanki.R;

public class ShopReqMenuListViewHolder extends RecyclerView.ViewHolder {
    //필수 메뉴
    RadioButton VH_reqRadioBtn;
    TextView VH_reqMenuSize;
    TextView VH_reqMenuPeople;
    TextView VH_reqMenuPrice;

    //선택 메뉴
    CheckBox VH_optCheckBox;
    TextView VH_optMenuTitle;
    TextView VH_optMenuPrice;
    ImageButton VH_optMenuPlusBtn;
    TextView VH_optMenuCount;
    ImageButton VH_optMenuSubBtn;
    LinearLayout VH_optToppingLinearlayout;

    //Recycler에서 opt와 require layout 선택시 라디오/체크박스 버튼 선택
    LinearLayout VH_optMenuLayout;
    LinearLayout VH_reqMenuLayout;

    public ShopReqMenuListViewHolder(View itemView) {
        super(itemView);

        VH_reqRadioBtn = (RadioButton) itemView.findViewById(R.id.reqMenuRadioBtn);
        VH_reqMenuSize = (TextView) itemView.findViewById(R.id.reqMenuSize);
        VH_reqMenuPeople = (TextView) itemView.findViewById(R.id.reqMenuPeople);
        VH_reqMenuPrice = (TextView) itemView.findViewById(R.id.reqMenuPrice);

        VH_optCheckBox = (CheckBox) itemView.findViewById(R.id.optMenuCheckBtn);
        VH_optMenuTitle = (TextView) itemView.findViewById(R.id.optMenuTitle);
        VH_optMenuPrice = (TextView) itemView.findViewById(R.id.optMenuPrice);
        VH_optMenuPlusBtn = (ImageButton) itemView.findViewById(R.id.optMenuPlusBtn);
        VH_optMenuCount = (TextView) itemView.findViewById(R.id.optMenuAddCount);
        VH_optMenuSubBtn = (ImageButton) itemView.findViewById(R.id.optMenuSubBtn);

        VH_optToppingLinearlayout = (LinearLayout) itemView.findViewById(R.id.menu_optToppingCountLayout);
        VH_optMenuLayout = (LinearLayout) itemView.findViewById(R.id.menu_optMenuLayout);
        VH_reqMenuLayout = (LinearLayout) itemView.findViewById(R.id.menu_reqMenuLayout);
    }
}

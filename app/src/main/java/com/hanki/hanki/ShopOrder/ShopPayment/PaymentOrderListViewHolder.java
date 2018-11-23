package com.hanki.hanki.ShopOrder.ShopPayment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanki.hanki.R;

public class PaymentOrderListViewHolder extends RecyclerView.ViewHolder {
    ImageView VH_foodImg;
    TextView VH_shopTitle;
    TextView VH_foodSize;
    TextView VH_topping;

    public PaymentOrderListViewHolder(View itemView) {
        super(itemView);

        VH_foodImg = (ImageView) itemView.findViewById(R.id.payment_foodImg);
        VH_shopTitle = (TextView) itemView.findViewById(R.id.payment_shopTitle);
        VH_foodSize = (TextView) itemView.findViewById(R.id.payment_foodSize);
        VH_topping = (TextView) itemView.findViewById(R.id.payment_topping);
    }
}

package com.hanki.hanki.ShopOrder.ShopPayment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hanki.hanki.R;

public class PaymentPayListViewHolder extends RecyclerView.ViewHolder {
    RadioButton VH_RadioBtn;
    TextView VH_PayName;
    LinearLayout VH_PaymentLayout;
    ImageView VH_PayImg;

    public PaymentPayListViewHolder(View itemView) {
        super(itemView);

        VH_RadioBtn = (RadioButton) itemView.findViewById(R.id.paymentPay_radioBtn);
        VH_PayName = (TextView) itemView.findViewById(R.id.paymentPay_payName);
        VH_PaymentLayout = (LinearLayout) itemView.findViewById(R.id.paymentPay_payLayout);
        VH_PayImg = (ImageView) itemView.findViewById(R.id.paymentPay_logo);
    }
}

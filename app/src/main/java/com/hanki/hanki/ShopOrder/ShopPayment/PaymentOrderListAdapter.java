package com.hanki.hanki.ShopOrder.ShopPayment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hanki.hanki.R;

import java.util.List;

public class PaymentOrderListAdapter extends RecyclerView.Adapter<PaymentOrderListViewHolder> {
    private Context context;
    private List<PaymentOrderListData> orderListData;


    public PaymentOrderListAdapter(Context context, List<PaymentOrderListData> orderListData) {
        this.context = context;
        this.orderListData = orderListData;
    }
    @NonNull
    @Override
    public PaymentOrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_menu_recycler, parent, false);
        PaymentOrderListViewHolder paymentOrderListViewHolder = new PaymentOrderListViewHolder(view);

        return paymentOrderListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOrderListViewHolder holder, int position) {
        //메뉴 이미지 세팅
//        Glide.with(context)
//                .load(orderListData.get(position).menuImage)
//                .apply(new RequestOptions().centerCrop())
//                .into(holder.VH_foodImage);

        holder.VH_menuName.setText(orderListData.get(position).menuName);
        holder.VH_menuSize.setText(orderListData.get(position).menuSize);
        holder.VH_menuTopping.setText(orderListData.get(position).menuTopping.toString().toString());

    }

    @Override
    public int getItemCount() {
        return orderListData != null ? orderListData.size() : 0 ;
    }
}

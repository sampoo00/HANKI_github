package com.hanki.hanki.NavigationBar.OrderHistory;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<OrderHistory> orderList;

    public OrderHistoryAdapter(Context context, ArrayList<OrderHistory> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_orderhistory_item, parent, false);
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OrderHistoryAdapter.OrderHistoryViewHolder viewHolder = (OrderHistoryAdapter.OrderHistoryViewHolder) holder;

        OrderHistory orderHistory = orderList.get(position);
        Glide.with(context).load(orderHistory.shopImage).into(viewHolder.orderHistory_shopImage);
        viewHolder.orderHistory_shopName.setText(orderHistory.shopName);
        viewHolder.orderHistory_date.setText(orderHistory.orderDate);

        if (orderHistory.pickUpType == 1) {
            viewHolder.orderHistory_pickUpType.setText("매장");
        } else if (orderHistory.pickUpType == 2) {
            viewHolder.orderHistory_pickUpType.setText("픽업");
        }

        if (orderHistory.orderFinish.equals("Y")) {
            viewHolder.orderHistory_orderFinish.setText("완료");
        } else if (orderHistory.orderFinish.equals("N")) {
            viewHolder.orderHistory_orderFinish.setText("대기");
        }

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderHistoryViewHolder extends RecyclerView.ViewHolder {

        CircleImageView orderHistory_shopImage;
        TextView orderHistory_shopName;
        TextView orderHistory_pickUpType;
        TextView orderHistory_date;
        TextView orderHistory_orderFinish;

        public OrderHistoryViewHolder(final View itemView) {
            super(itemView);

            orderHistory_shopImage = (CircleImageView) itemView.findViewById(R.id.orderHistory_shopImage);
            orderHistory_shopName = (TextView) itemView.findViewById(R.id.orderHistory_shopName);
            orderHistory_pickUpType = (TextView) itemView.findViewById(R.id.orderHistory_pickUpType);
            orderHistory_date = (TextView) itemView.findViewById(R.id.orderHistory_date);
            orderHistory_orderFinish = (TextView) itemView.findViewById(R.id.orderHistory_orderFinish);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, OrderDetailActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

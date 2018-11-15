package com.hanki.hanki.ShopOrder.ShopMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.hanki.hanki.R;

import java.util.List;

public class ShopReqMenuListAdapter extends RecyclerView.Adapter<ShopReqMenuListViewHolder> {
    private Context context;
    private List<ShopReqMenuData> reqMenuData;
    private RadioButton lastCheckedRB = null;


    public ShopReqMenuListAdapter(Context context, List<ShopReqMenuData> reqMenuData) {
        this.context = context;
        this.reqMenuData = reqMenuData;
    }

    @NonNull
    @Override
    public ShopReqMenuListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_menu_reqmenu_recycler, parent, false);
        ShopReqMenuListViewHolder shopReqMenuListViewHolder = new ShopReqMenuListViewHolder(view);

        return shopReqMenuListViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ShopReqMenuListViewHolder holder, final int position) {

        holder.VH_reqMenuSize.setText(reqMenuData.get(position).reqMenuSize);
        holder.VH_reqMenuPeople.setText(reqMenuData.get(position).reqMenuPeople);
        holder.VH_reqMenuPrice.setText(reqMenuData.get(position).reqMenuPrice);
        holder.VH_reqRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastCheckedRB != null){
                    lastCheckedRB.setChecked(false);
                }
                lastCheckedRB = holder.VH_reqRadioBtn;
            }
        });
    }

    @Override
    public int getItemCount() {
        return reqMenuData != null ? reqMenuData.size() : 0 ;
    }
}

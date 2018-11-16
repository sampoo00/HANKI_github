package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.hanki.hanki.R;

import java.text.DecimalFormat;
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

    //천 단위 숫자 입력
    public static String moneyFormat(int inputMoney) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return decimalFormat.format(inputMoney);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ShopReqMenuListViewHolder holder, final int position) {

        holder.VH_reqMenuSize.setText(reqMenuData.get(position).reqMenuSize);
        holder.VH_reqMenuPeople.setText(reqMenuData.get(position).reqMenuPeople);
        holder.VH_reqMenuPrice.setText(String.valueOf(moneyFormat(reqMenuData.get(position).reqMenuPrice))+"원");
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

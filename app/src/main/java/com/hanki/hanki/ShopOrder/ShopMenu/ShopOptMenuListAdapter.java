package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.hanki.hanki.R;

import java.text.DecimalFormat;
import java.util.List;

public class ShopOptMenuListAdapter extends RecyclerView.Adapter<ShopReqMenuListViewHolder> {
    private Context context;
    private List<ShopOptMenuData> optMenuData;
    int toppingMenuCount = 0 ;

    public ShopOptMenuListAdapter(Context context, List<ShopOptMenuData> optMenuData) {
        this.context = context;
        this.optMenuData = optMenuData;
    }

    @NonNull
    @Override
    public ShopReqMenuListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_menu_optmenu_recycler, parent, false);
        ShopReqMenuListViewHolder shopReqMenuListViewHolder = new ShopReqMenuListViewHolder(view);

        return shopReqMenuListViewHolder;
    }

    //천 단위 숫자 입력
    public static String moneyFormat(int inputMoney) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return decimalFormat.format(inputMoney);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopReqMenuListViewHolder holder, final int position) {
        holder.VH_optMenuTitle.setText(optMenuData.get(position).optMenuTitle);
        holder.VH_optMenuPrice.setText(String.valueOf(moneyFormat(optMenuData.get(position).optMenuPrice)+"원"));

        if(optMenuData.get(position).getOptMenuCount()==0){
            optMenuData.get(position).setOptMenuCount(0);
            toppingMenuCount = 0;
        }

        holder.VH_optCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    holder.VH_optToppingLinearlayout.setVisibility(View.VISIBLE);
                }
                else{
                    holder.VH_optToppingLinearlayout.setVisibility(View.GONE);
                    toppingMenuCount = 0;
                    optMenuData.get(position).setOptMenuCount(0);
                    holder.VH_optMenuCount.setText(optMenuData.get(position).optMenuCount);

                }
            }
        });


        holder.VH_optMenuPlusBtn.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                    toppingMenuCount = optMenuData.get(position).getOptMenuCount();
                    if(toppingMenuCount < 99) {
                        toppingMenuCount = toppingMenuCount + 1;
                    }
                    else{
                        toppingMenuCount = 99;
                    }
                    optMenuData.get(position).setOptMenuCount(toppingMenuCount);
                    holder.VH_optMenuCount.setText(String.valueOf(toppingMenuCount));

            }
        });

        holder.VH_optMenuSubBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toppingMenuCount == 0){
                    toppingMenuCount = 0;
                }
                else{
                    toppingMenuCount = toppingMenuCount -1;
                }
                optMenuData.get(position).setOptMenuCount(toppingMenuCount);
                holder.VH_optMenuCount.setText(String.valueOf(toppingMenuCount));

            }
        });
    }

    @Override
    public int getItemCount() {
        return optMenuData != null ? optMenuData.size() : 0;
    }

}

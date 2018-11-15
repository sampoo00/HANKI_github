package com.hanki.hanki.ShopOrder.ShopMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.hanki.hanki.R;

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

    @Override
    public void onBindViewHolder(@NonNull final ShopReqMenuListViewHolder holder, final int position) {
        holder.VH_optMenuTitle.setText(optMenuData.get(position).optMenuTitle);
        holder.VH_optMenuPrice.setText(optMenuData.get(position).optMenuPrice);

        if(optMenuData.get(position).getOptMenuCount()==null){
            optMenuData.get(position).setOptMenuCount("0");
            toppingMenuCount = 0;
        }

        holder.VH_optCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    holder.VH_optLinearLayout.setVisibility(View.VISIBLE);
                }
                else{
                    holder.VH_optLinearLayout.setVisibility(View.GONE);
                    toppingMenuCount = 0;
                    optMenuData.get(position).setOptMenuCount("0");
                    holder.VH_optMenuCount.setText(optMenuData.get(position).optMenuCount);

                }
            }
        });


        holder.VH_optMenuPlusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    toppingMenuCount = Integer.parseInt(optMenuData.get(position).getOptMenuCount());
                    if(toppingMenuCount < 99) {
                        toppingMenuCount = toppingMenuCount + 1;
                    }
                    else{
                        toppingMenuCount = 99;
                    }
                    optMenuData.get(position).setOptMenuCount("" + toppingMenuCount);
                    holder.VH_optMenuCount.setText(optMenuData.get(position).optMenuCount);

            }
        });

        holder.VH_optMenuSubBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                toppingMenuCount = Integer.parseInt(optMenuData.get(position).getOptMenuCount());
                if(toppingMenuCount == 0){
                    toppingMenuCount = 0;
                }
                else{
                    toppingMenuCount = toppingMenuCount -1;
                }
                optMenuData.get(position).setOptMenuCount(""+ toppingMenuCount);
                holder.VH_optMenuCount.setText(optMenuData.get(position).optMenuCount);

            }
        });
    }

    @Override
    public int getItemCount() {
        return optMenuData != null ? optMenuData.size() : 0;
    }
//    private List<ShopReqMenuData> reqMenuData;
//    private RadioButton lastCheckedRB = null;
//
//
//    public ShopOptMenuListAdapter(Context context, List<ShopReqMenuData> reqMenuData) {
//        this.context = context;
//        this.reqMenuData = reqMenuData;
//    }
//
//    @NonNull
//    @Override
//    public ShopReqMenuListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_menu_reqmenu_recycler, parent, false);
//        ShopReqMenuListViewHolder shopReqMenuListViewHolder = new ShopReqMenuListViewHolder(view);
//
//        return shopReqMenuListViewHolder;
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ShopReqMenuListViewHolder holder, final int position) {
//
//        holder.VH_reqMenuSize.setText(reqMenuData.get(position).reqMenuSize);
//        holder.VH_reqMenuPeople.setText(reqMenuData.get(position).reqMenuPeople);
//        holder.VH_reqMenuPrice.setText(reqMenuData.get(position).reqMenuPrice);
//        holder.VH_reqRadioBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(lastCheckedRB != null){
//                    lastCheckedRB.setChecked(false);
//                }
//                lastCheckedRB = holder.VH_reqRadioBtn;
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return reqMenuData != null ? reqMenuData.size() : 0 ;
//    }
}

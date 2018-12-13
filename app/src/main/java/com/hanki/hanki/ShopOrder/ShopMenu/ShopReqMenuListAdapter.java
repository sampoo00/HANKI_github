package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.ShopOrder.NetworkItem.ToppingData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.hanki.hanki.ShopOrder.ShopMenu.ShopMenuDialog.*;

public class ShopReqMenuListAdapter extends RecyclerView.Adapter<ShopReqMenuListViewHolder> {
    private Context context;
    private ArrayList<ToppingData> reqMenuData;
    private RadioButton lastCheckedRB = null;
    boolean checked = false;
    private int lastPosition = 0;


    public ShopReqMenuListAdapter(Context context, ArrayList<ToppingData> reqMenuData) {
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

        holder.VH_reqMenuSize.setText(reqMenuData.get(position).getToppingName());
//        holder.VH_reqMenuPeople.setText(reqMenuData.get(position).menuPeople);
        holder.VH_reqMenuPrice.setText(String.valueOf(moneyFormat(reqMenuData.get(position).getToppingPrice()))+"원");
        if(position == 0){
            holder.VH_reqRadioBtn.setChecked(true);
            lastCheckedRB = holder.VH_reqRadioBtn;
            lastPosition = position;
            ((ShopMenuDialog) ShopMenuDialog.mContext).addReqPrice(reqMenuData.get(position).getToppingPrice());

        }

        holder.VH_reqRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (lastCheckedRB != null) {
                    if(lastCheckedRB!=holder.VH_reqRadioBtn && !checked){
                        checked = true;
                        lastCheckedRB.setChecked(false); //이거하면 change되는거임)
                    }
                    else if(lastCheckedRB==holder.VH_reqRadioBtn && !checked){
                        checked = true;
                        lastCheckedRB.setChecked(true);
                    }
                    ((ShopMenuDialog) ShopMenuDialog.mContext).subReqPrice(reqMenuData.get(lastPosition).getToppingPrice());
                    checked = false;
                }


                lastCheckedRB = holder.VH_reqRadioBtn;
                lastPosition = position;


                ((ShopMenuDialog) ShopMenuDialog.mContext).addReqPrice(reqMenuData.get(position).getToppingPrice());
            }

        });



        holder.VH_reqMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.VH_reqRadioBtn.isChecked()){
                    holder.VH_reqRadioBtn.setChecked(false);
                }else {
                    holder.VH_reqRadioBtn.setChecked(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return reqMenuData != null ? reqMenuData.size() : 0 ;
    }
}

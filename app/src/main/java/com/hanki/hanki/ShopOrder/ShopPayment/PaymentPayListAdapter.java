package com.hanki.hanki.ShopOrder.ShopPayment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.ShopMenu.ShopMenuDialog;

import java.util.ArrayList;

public class PaymentPayListAdapter extends RecyclerView.Adapter<PaymentPayListViewHolder> {
    Context context;
    private ArrayList<PaymentPayListData> payListData;
    private int lastPosition;
    private RadioButton lastCheckedRB = null;
    boolean check = false;


    public PaymentPayListAdapter(Context context,  ArrayList<PaymentPayListData> payListData) {
        this.context = context;
        this.payListData = payListData;
    }

    @NonNull
    @Override
    public PaymentPayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paymentpay_paylist_recycler, parent, false);
        PaymentPayListViewHolder paymentPayListViewHolder = new PaymentPayListViewHolder(view);

        return paymentPayListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PaymentPayListViewHolder holder, final int position) {

        holder.VH_PayName.setText(payListData.get(position).payName);
        if(payListData.get(position).payImg != 0) {
            holder.VH_PayImg.setBackgroundResource(payListData.get(position).getPayImg());
        }else{
            holder.VH_PayImg.setVisibility(View.GONE);
        }
        lastPosition = ((PaymentPayActivity)PaymentPayActivity.mContext).mLogoPosition;

        if(position == lastPosition) { //기본 값 지정
            holder.VH_RadioBtn.setChecked(true);
            lastCheckedRB = holder.VH_RadioBtn;
            lastPosition = position;
            ((PaymentPayActivity)PaymentPayActivity.mContext).setLogoInfo(lastPosition, payListData.get(position).getPayImg(), payListData.get(position).getPayName());
        }



        holder.VH_RadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(lastCheckedRB != null){
                    if(lastCheckedRB != holder.VH_RadioBtn && !check){
                        check = true;
                        lastCheckedRB.setChecked(false);
                    }else if(lastCheckedRB == holder.VH_RadioBtn && !check){
                        check = true;
                        lastCheckedRB.setChecked(true);
                    }

                    check = false;
                }
                lastCheckedRB = holder.VH_RadioBtn;
                lastPosition = position;

                ((PaymentPayActivity)PaymentPayActivity.mContext).setLogoInfo(lastPosition, payListData.get(position).getPayImg(), payListData.get(position).getPayName());

            }
        });



        holder.VH_PaymentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if(holder.VH_RadioBtn.isChecked()){
                            holder.VH_RadioBtn.setChecked(false);
                        }else {
                            holder.VH_RadioBtn.setChecked(true);
                        }
                    }
        });

    }

    @Override
    public int getItemCount() {
        return payListData != null ? payListData.size() : 0 ;
    }
}

package com.hanki.hanki.FoodTray;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hanki.hanki.NumberTicket.NetworkItem.OrderedListData;
import com.hanki.hanki.R;

import java.util.List;

public class Fragment_FoodTray extends Fragment {
    RelativeLayout mOrderLayout;

    //메뉴 리스트
    private RecyclerView mFoodTrayRecyclerView;
    private LinearLayoutManager mFoodTrayLinearLayoutManager;
    private FoodTrayOrderListAdapter mPaymentAdapter;
    List<OrderedListData> mOrderList;

    public Fragment_FoodTray() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_foodtray, container, false);
        init(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void init(View view){

        mOrderLayout = view.findViewById(R.id.foodTray_toOrderLayout);
        mOrderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "결제하기", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hanki.hanki.R;

import java.util.Arrays;
import java.util.List;

import static com.hanki.hanki.R.*;

public class ShopMenuDialog extends Dialog {
    //필수 메뉴
    private RecyclerView mReqMenuRecyclerView;
    private LinearLayoutManager mReqMenuLinearLayoutManager;
    private ShopReqMenuListAdapter mReqMenuAdapter;
    List<ShopReqMenuData> mReqMenuList;

    //선택 메뉴
    private RecyclerView mOptMenuRecyclerView;
    private LinearLayoutManager mOptMenuLinearLayoutManager;
    private ShopOptMenuListAdapter mOptMenuAdapter;
    List<ShopOptMenuData> mOptMenuList;

    //총수량
    int mTotalCountInt;
    ImageButton mTotalSubBtn;
    TextView mTotalMenuCount;
    ImageButton mTotalAddBtn;

    //수령 방법, radio btn

    //전달 사항 UI 생성

    //식판 담기, 주문하기
    //총 주문 금액
    public static int totalPrice = 0;


    //총 주문 금액 계산하는 함수

    public void init(){
        mTotalCountInt = 0;
        mTotalSubBtn = (ImageButton)findViewById(R.id.menu_totalSubBtn);
        mTotalMenuCount = (TextView) findViewById(id.menu_totalAddCount);
        mTotalAddBtn = (ImageButton)findViewById(id.menu_totalPlusBtn);
        mTotalMenuCount.setText("0");



        mTotalAddBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mTotalCountInt = Integer.parseInt(mTotalMenuCount.getText().toString());
                if( mTotalCountInt < 99) {
                    mTotalCountInt = mTotalCountInt + 1;
                }
                else{
                    mTotalCountInt = 99;
                }
                mTotalMenuCount.setText(""+mTotalCountInt);
            }
        });

        mTotalSubBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mTotalCountInt = Integer.parseInt(mTotalMenuCount.getText().toString());
                if (mTotalCountInt == 0) {
                    mTotalCountInt = 0;
                } else {
                    mTotalCountInt = mTotalCountInt - 1;
                }
                mTotalMenuCount.setText("" + mTotalCountInt);
            }
        });

    }


    public void initRecycler(){

        mReqMenuRecyclerView = (RecyclerView) findViewById(id.menu_reqRecyclerView);
        mReqMenuLinearLayoutManager = new LinearLayoutManager(getContext());
        mReqMenuLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mOptMenuRecyclerView = (RecyclerView) findViewById(id.menu_optRecyclerView);
        mOptMenuLinearLayoutManager = new LinearLayoutManager(getContext());
        mOptMenuLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mReqMenuRecyclerView.setLayoutManager(mReqMenuLinearLayoutManager);
        mReqMenuRecyclerView.setHasFixedSize(true);
        mOptMenuRecyclerView.setLayoutManager(mOptMenuLinearLayoutManager);
        mOptMenuRecyclerView.setHasFixedSize(true);

        initArrayList();

        mReqMenuAdapter = new ShopReqMenuListAdapter(getContext(), mReqMenuList);
        mReqMenuRecyclerView.setAdapter(mReqMenuAdapter);
        mOptMenuAdapter = new ShopOptMenuListAdapter(getContext(), mOptMenuList);
        mOptMenuRecyclerView.setAdapter(mOptMenuAdapter);

    }


    public ShopMenuDialog(@NonNull Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(layout.shop_menu_dialog);

        init();
        initRecycler();
//참고
//        searchedDialog_closeBtn = (ImageButton) findViewById(R.id.searchedDialog_closeBtn);
//        searchedDialog_closeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });

    }

    public void initArrayList(){

        mReqMenuList = Arrays.asList(new ShopReqMenuData("대","5~6인", "26,000원"),
                new ShopReqMenuData("중", "3~4인", "23,000원"),
                new ShopReqMenuData("소", "1~2인", "20,000원"),
                new ShopReqMenuData("대","5~6인", "26,000원"),
                new ShopReqMenuData("중", "3~4인", "23,000원"),
                new ShopReqMenuData("소", "1~2인", "20,000원"));

        mOptMenuList = Arrays.asList(new ShopOptMenuData("라면사리", "1000원"),
                new ShopOptMenuData("떡사리", "2000원"),
        new ShopOptMenuData("모둠사리", "4000원"),
        new ShopOptMenuData("치즈", "2000원"),
        new ShopOptMenuData("파", "500원"));

    }


}

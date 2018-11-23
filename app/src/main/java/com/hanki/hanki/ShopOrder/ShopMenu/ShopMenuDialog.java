package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static com.hanki.hanki.R.*;

public class ShopMenuDialog extends Dialog {
    NestedScrollView mNestScroll;
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
    RadioGroup mPickupGroup;
    RadioButton mPickupType;
    RadioButton mNonPickupType;

    //전달 사항 UI 생성
    EditText mRequestTxt;

    //식판 담기, 주문하기
    //총 주문 금액
    //필수 선택
    int mReqMenuPrice = 0;
    int mOptMenuPrice = 0;
    TextView mCalTotalPrice;
    int mTotalPrice = 0;
    public static ShopMenuDialog mContext;

    //총 주문 금액 계산하는 함수


    public void initPickupType(){
        mPickupGroup = (RadioGroup) findViewById(id.menu_RadioGroup);
        mPickupType = (RadioButton) findViewById(id.menu_pickupRadioBtn);
        mNonPickupType = (RadioButton) findViewById(id.menu_nonPickupRadioBtn);
    }
    public void initTotalCount(){
        mTotalCountInt = 1;
        mTotalSubBtn = (ImageButton)findViewById(id.menu_totalSubBtn);
        mTotalMenuCount = (TextView) findViewById(id.menu_totalAddCount);
        mTotalAddBtn = (ImageButton)findViewById(id.menu_totalPlusBtn);
        mTotalMenuCount.setText(String.valueOf(mTotalCountInt));



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
                resultTotalPrice();

            }
        });

        mTotalSubBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mTotalCountInt = Integer.parseInt(mTotalMenuCount.getText().toString());
                if (mTotalCountInt == 1) {
                    mTotalCountInt = 1;
                } else {
                    mTotalCountInt = mTotalCountInt - 1;
                }
                mTotalMenuCount.setText("" + mTotalCountInt);
                resultTotalPrice();

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


    public void initRequest(){
        mNestScroll = (NestedScrollView) findViewById(id.menu_ScrollView);
        mRequestTxt = (EditText) findViewById(id.menu_inputRequestTxt);


        mRequestTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == true) {
                    mNestScroll.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mNestScroll.smoothScrollBy(0, 800);
                        }
                    }, 100);

                }
            }
        });
    }

    //천 단위 숫자 입력
    public static String moneyFormat(int inputMoney) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return decimalFormat.format(inputMoney);
    }

    public void subReqPrice(int price){
            mReqMenuPrice = mReqMenuPrice - price;
            resultTotalPrice();
    }

    public void addReqPrice(int price){
        mReqMenuPrice = mReqMenuPrice + price;
        resultTotalPrice();
    }

    public void subOptPrice(int price){
        mOptMenuPrice = mOptMenuPrice - price;
        resultTotalPrice();
    }

    public void addOptPrice(int price){
        mOptMenuPrice = mOptMenuPrice + price;
        resultTotalPrice();
    }

    public void resultTotalPrice(){
        mCalTotalPrice.setText(String.valueOf(moneyFormat((mReqMenuPrice+mOptMenuPrice) * mTotalCountInt)));

    }

    public int getTotalPrice(){
        mTotalPrice = (mReqMenuPrice + mOptMenuPrice) * mTotalCountInt;
        return mTotalPrice;
    }


    public ShopMenuDialog(@NonNull Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(layout.shop_menu_dialog);
        mContext = this;
        mCalTotalPrice = (TextView) findViewById(id.menu_totalPrice);
        mCalTotalPrice.setText("0");


        initTotalCount();
        initRecycler();
        initPickupType();
        initRequest();

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

        mReqMenuList = Arrays.asList(new ShopReqMenuData("대","5~6인", 1326000),
                new ShopReqMenuData("중", "3~4인", 23000),
                new ShopReqMenuData("소", "1~2인", 20000),
                new ShopReqMenuData("대","5~6인", 26000),
                new ShopReqMenuData("중", "3~4인", 23000),
                new ShopReqMenuData("소", "1~2인", 20000));

        mOptMenuList = Arrays.asList(new ShopOptMenuData("라면사리", 1000),
                new ShopOptMenuData("떡사리", 2000),
        new ShopOptMenuData("모둠사리", 4000),
        new ShopOptMenuData("치즈", 2000),
        new ShopOptMenuData("파", 500));

    }


}

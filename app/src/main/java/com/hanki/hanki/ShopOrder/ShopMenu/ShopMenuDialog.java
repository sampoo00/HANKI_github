package com.hanki.hanki.ShopOrder.ShopMenu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.ShopOrder.NetworkItem.ToppingData;
import com.hanki.hanki.ShopOrder.NetworkItem.ToppingResult;
import com.hanki.hanki.ShopOrder.ShopPayment.PaymentActivity;
import com.hanki.hanki.Util.Application;
import com.hanki.hanki.Util.NetworkService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hanki.hanki.R.*;

public class ShopMenuDialog extends Dialog {
    String TAG = "check2";
    NestedScrollView mNestScroll;
    //필수 메뉴
    private RecyclerView mReqMenuRecyclerView;
    private LinearLayoutManager mReqMenuLinearLayoutManager;
    private ShopReqMenuListAdapter mReqMenuAdapter;
    ArrayList<ToppingData> mReqMenuList = new ArrayList<>();

    //선택 메뉴
    private RecyclerView mOptMenuRecyclerView;
    private LinearLayoutManager mOptMenuLinearLayoutManager;
    private ShopOptMenuListAdapter mOptMenuAdapter;
    ArrayList<ToppingData> mOptMenuList = new ArrayList<>();

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

    //식판 담기, 주문 하기
    LinearLayout addCartLayout;
    LinearLayout orderMenuLayout;

    //Menu와 topping
    int mShopOrderType;
    String mSelectedShopCode;
    MenuData mSelectedMenuData;
    ArrayList<ToppingData> toppingDataList = new ArrayList<>();

    //메뉴판
    ImageView mMenuImg;
    TextView mMenuTitle;
    RelativeLayout mReqMenuLayout; //menu_reqMenuLayout
    ImageView mFirstMenuDotLine; //menu_dotline2

    RelativeLayout mOptMenuLayout; //menu_optMenuLayout
    ImageView mSecondMenuDotLine; //menu_dotline3







    public void initPickupType(){
        mPickupGroup = (RadioGroup) findViewById(id.menu_RadioGroup);
        mPickupType = (RadioButton) findViewById(id.menu_pickupRadioBtn);
        mNonPickupType = (RadioButton) findViewById(id.menu_nonPickupRadioBtn);

        mPickupType.setChecked(true);

        mPickupGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case id.menu_pickupRadioBtn :
                        Toast.makeText(getContext(), "매장이 선택 되었습니다.", Toast.LENGTH_SHORT).show();
                        break;

                    case id.menu_nonPickupRadioBtn :
                        Toast.makeText(getContext(), "픽업이 선택 되었습니다.", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

//        mPickupType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(mPickupType.isChecked()){
//                    Toast.makeText(getContext(), "매장이 선택 되었습니다.", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getContext(), "매장이 선택 해제 되었습니다.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        mNonPickupType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(mNonPickupType.isChecked()){
//                    Toast.makeText(getContext(), "픽업이 선택 되었습니다.", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getContext(), "픽업이 선택 해제 되었습니다.", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
    }

    //초기 수량
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


    //요청 사항
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

    //계산 함수
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

    public void initCartOrder(){
        addCartLayout = (LinearLayout) findViewById(id.menu_addCartLayout);
        orderMenuLayout = (LinearLayout) findViewById(id.menu_orderLayout);

        //식판 담기
        addCartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "식판에 담겼습니다", Toast.LENGTH_SHORT).show();
            }
        });

        //주문하기
        orderMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PaymentActivity.class);
                getContext().startActivity(intent);
            }
        });

    }

    public void init(){
        mMenuImg = (ImageView) findViewById(id.menu_MenuImg);
        mMenuTitle = (TextView) findViewById(id.menu_MenuTitle);
        mReqMenuLayout = (RelativeLayout) findViewById(id.menu_reqMenuLayout); //
        mFirstMenuDotLine = (ImageView) findViewById(id.menu_dotline2); //만약 Req 안나오게 하면 같이 없애야함

        mOptMenuLayout = (RelativeLayout) findViewById(id.menu_optMenuLayout); //menu_optMenuLayout
        mSecondMenuDotLine = (ImageView) findViewById(id.menu_dotline3); //opt안나오게 하려면 같이 삭제
    }



    public ShopMenuDialog(@NonNull Context context, MenuData menuData, String shopCode, int orderType) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(layout.shop_menu_dialog);
        mContext = this;
        mSelectedMenuData = menuData;
        mSelectedShopCode = shopCode;
        mShopOrderType = orderType;
        mCalTotalPrice = (TextView) findViewById(id.menu_totalPrice);
        mCalTotalPrice.setText("0");

        init();
        getToppingNetworking();
        initTotalCount();
        initPickupType();
        initRequest();
//        initRecycler();
        initCartOrder();

        //참고
//        searchedDialog_closeBtn = (ImageButton) findViewById(R.id.searchedDialog_closeBtn);
//        searchedDialog_closeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });

    }

    public void setToppingResult(ToppingResult toppingResult) {
        if(toppingResult.description.equals("success")) { //description이 success인 경우
            toppingDataList.addAll(toppingResult.result);


            String imageUrl = Application.getInstance().imageUrl + "menu/"
                    + mSelectedShopCode + "/" + mSelectedMenuData.getMenuImgId();
            Glide.with(getContext()).load(imageUrl).into(mMenuImg);

            mMenuTitle.setText(mSelectedMenuData.getMenuName());

            Log.d(TAG, "pickupType : " + mShopOrderType);

            // 매장 주문 타입 - 1: 현장/픽업, 2: 현장 only, 3: 픽업 only
            if(mShopOrderType == 1) {
                mPickupType.setVisibility(View.VISIBLE);
                mNonPickupType.setVisibility(View.VISIBLE);
                Log.d(TAG, "pickup&nonPickup : " + mShopOrderType);

            } else if(mShopOrderType == 2) {
                mPickupType.setVisibility(View.GONE);
                mNonPickupType.setVisibility(View.VISIBLE);
                Log.d(TAG, "nonPickup : " + mShopOrderType);

            } else if (mShopOrderType == 3) {
                mPickupType.setVisibility(View.VISIBLE);
                mNonPickupType.setVisibility(View.GONE);
                Log.d(TAG, "pickup : " + mShopOrderType);
            }

            initRecycler();
        }
    }

    public void getToppingNetworking(){
        NetworkService networkService = Application.getInstance().getNetworkService();

        //toppingKey
        String toppingKey = mSelectedMenuData.getToppingKey();

        Log.d(TAG, toppingKey);

        //통신
        Call<ToppingResult> request = networkService.getToppingResult(toppingKey);
        request.enqueue(new Callback<ToppingResult>() {
            @Override
            public void onResponse(Call<ToppingResult> call, Response<ToppingResult> response) {
                if (response.isSuccessful()) {
                    ToppingResult toppingResult = response.body();
                    setToppingResult(toppingResult);

                    Log.d(TAG, "토핑 다이얼로그 성공");
                }
            }

            @Override
            public void onFailure(Call<ToppingResult> call, Throwable t) {
                Log.d(TAG, "토핑 조회 실패 : " + t.getMessage());
            }
        });

    }

    public void initArrayList(){
        Log.d(TAG, "toppingDatalist" + toppingDataList);

        if (toppingDataList != null) {
            if (toppingDataList.size() != 0) {
                for (int i = 0; i < toppingDataList.size(); i++) {
                    if (toppingDataList.get(i).getToppingGroupName().equals("사이즈")) { //카테고리가 main인 menuList 구성
                        mReqMenuList.add(toppingDataList.get(i));
                        Log.d(TAG, "mReqMenuList.add" + mReqMenuList.get(i).toString());
                    } else if (toppingDataList.get(i).getToppingGroupName().equals("추가선택")) { //카테고리가 sub인 menuList 구성
                        mOptMenuList.add(toppingDataList.get(i));
                        Log.d(TAG, "mOptMenuList.add" + mOptMenuList.get(i).toString());

                    }
                }
            }
        }

//        mReqMenuList = Arrays.asList(new ShopReqMenuData("대","5~6인", 1326000),
//                new ShopReqMenuData("중", "3~4인", 23000),
//                new ShopReqMenuData("소", "1~2인", 20000),
//                new ShopReqMenuData("대","5~6인", 26000),
//                new ShopReqMenuData("중", "3~4인", 23000),
//                new ShopReqMenuData("소", "1~2인", 20000));
//
//        mOptMenuList = Arrays.asList(new ShopOptMenuData("라면사리", 1000),
//                new ShopOptMenuData("떡사리", 2000),
//        new ShopOptMenuData("모둠사리", 4000),
//        new ShopOptMenuData("치즈", 2000),
//        new ShopOptMenuData("파", 500));

    }


}

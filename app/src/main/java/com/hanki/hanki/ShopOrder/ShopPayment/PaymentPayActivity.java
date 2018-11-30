package com.hanki.hanki.ShopOrder.ShopPayment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hanki.hanki.R;

import java.util.ArrayList;


public class PaymentPayActivity extends AppCompatActivity {
    Toolbar mToolbar;
    private RecyclerView mPayRecyclerView;
    private LinearLayoutManager mPayLinearLayoutManager;
    private PaymentPayListAdapter mPayListAdapter;
    ArrayList<PaymentPayListData> mPayListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_pay);

        init();


    }

    public void setUpToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("매장 이름2"); // toolbar 제목
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void initRecyclerView(){
        mPayRecyclerView = (RecyclerView) findViewById(R.id.paymentPay_RecyclerView);
        mPayLinearLayoutManager = new LinearLayoutManager(this);
        mPayLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mPayRecyclerView.setLayoutManager(mPayLinearLayoutManager);
        mPayRecyclerView.setHasFixedSize(true);


        mPayListData = new ArrayList<>();
        mPayListData.add(new PaymentPayListData("카카오 페이"));
        mPayListData.add(new PaymentPayListData("네이버 페이"));
        mPayListData.add(new PaymentPayListData("페이코"));
        mPayListData.add(new PaymentPayListData("신용카드 결제"));
        mPayListData.add(new PaymentPayListData("휴대폰 결제"));



        mPayListAdapter = new PaymentPayListAdapter(this, mPayListData);
        mPayRecyclerView.setAdapter(mPayListAdapter);
    }


    public void init(){
        mToolbar = (Toolbar) findViewById(R.id.paymentPay_toolbar);
        setUpToolbar();

        initRecyclerView();
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.paymentPay_choiceLayout:
                Intent intent = new Intent(this, PaymentActivity.class);
                finish();
                startActivity(intent);
                break;
        }
    }
}

package com.hanki.hanki.ShopOrder.ShopPayment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hanki.hanki.R;

import java.util.Arrays;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {
    Toolbar mToolbar;

    //메뉴 리스트
    private RecyclerView mOrderRecyclerView;
    private LinearLayoutManager mOrderLinearLayoutManager;
    private PaymentOrderListAdapter mPaymentAdapter;
    List<PaymentOrderListData> mOrderList;

    //결제하기
    RelativeLayout mToOrderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        init();
        setupToolbar();


    }

    public void init(){
        mToolbar = (Toolbar) findViewById(R.id.payment_toolbar);

        initRecyclerView();

        mToOrderLayout = (RelativeLayout) findViewById(R.id.payment_toOrderLayout);
    }

    public void initRecyclerView(){
        mOrderRecyclerView = (RecyclerView) findViewById(R.id.payment_orderListRecyclerView);
        mOrderLinearLayoutManager = new LinearLayoutManager(this);
        mOrderLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mOrderRecyclerView.setLayoutManager(mOrderLinearLayoutManager);
        mOrderRecyclerView.setHasFixedSize(true);

        initList();

        mPaymentAdapter = new PaymentOrderListAdapter(this, mOrderList);
        mOrderRecyclerView.setAdapter(mPaymentAdapter);
    }

    public void initList(){

        mOrderList = Arrays.asList(new PaymentOrderListData("케이크", "중",
                new String[]{"딸기", "라즈베리"}),
                new PaymentOrderListData("케이크2", "소",
                        new String[]{"딸기2", "라즈베리2"}),
                new PaymentOrderListData("케이크3", "대",
                        new String[]{"딸기3", "라즈베리3"}),
                new PaymentOrderListData("케이크4", "대",
                        new String[]{"딸기4", "라즈베리4"}),
                new PaymentOrderListData("케이크4-1", "대",
                        new String[]{"딸기4-1", "라즈베리4-1"}),
                new PaymentOrderListData("케이크5", "대",
                        new String[]{"딸기5", "라즈베리5", "라즈베리5", "라즈베리5", "라즈베리5", "라즈베리5"}));



    }
    public void setupToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("매장 이름"); // toolbar 제목
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_toOrderLayout:
                Toast.makeText(getApplicationContext(), "결제하기", Toast.LENGTH_SHORT).show();

        }
    }
}

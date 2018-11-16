package com.hanki.hanki.NavigationBar.OrderHistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hanki.hanki.R;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.orderDetail_closeBtn:
                finish();
                break;
        }
    }
}

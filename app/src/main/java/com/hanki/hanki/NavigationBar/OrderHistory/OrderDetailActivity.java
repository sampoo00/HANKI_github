package com.hanki.hanki.NavigationBar.OrderHistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hanki.hanki.R;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        init();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.orderDetail_closeBtn:
                finish();
                break;
        }
    }

    public void init() {
        ImageView order_detail_menuImage = (ImageView) findViewById(R.id.order_detail_menuImage);
        Glide.with(this).load("http://admin.cjrecipe.com/images/theKitchen/PHON/0000002359/0000009976/0000002359.jpg")
                .apply(new RequestOptions().centerCrop())
                .into(order_detail_menuImage);
    }
}

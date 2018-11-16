package com.hanki.hanki.NavigationBar.OrderHistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.hanki.hanki.LikeShop.LikeShopAdapter;
import com.hanki.hanki.R;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        init();
    }

    public void init() {
        Toolbar orderHistory_toolbar = (Toolbar) findViewById(R.id.orderHistory_toolbar);
        orderHistory_toolbar.setTitle("주문 내역");
        setSupportActionBar(orderHistory_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView orderHistory_recyclerview = (RecyclerView) findViewById(R.id.orderHistory_recyclerview);
        orderHistory_recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        OrderHistoryAdapter orderHistoryAdapter = new OrderHistoryAdapter(getApplicationContext(), getOrderList());
        orderHistory_recyclerview.setAdapter(orderHistoryAdapter);
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

    public ArrayList<OrderHistory> getOrderList() {
        ArrayList<OrderHistory> orderList = new ArrayList<>();
        OrderHistory orderHistory;
        for (int i = 0; i < 3; i++) {
            orderHistory = new OrderHistory("놀부 부대찌개",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRg80ZD8MEe9fgLohgoteq3vSZ6UTNqF0kiOaCce7TaEngpalJ",
                    "2018.10.05", 1, "Y");
            orderList.add(orderHistory);

            orderHistory = new OrderHistory("파스타 하우스",
                    "https://i0.wp.com/dilite.co.kr/wp-content/uploads/2018/04/%ED%8C%8C%EC%8A%A4%ED%83%80.jpg?fit=800505",
                    "2018.11.16", 2, "N");
            orderList.add(orderHistory);
        }
        return orderList;
    }
}

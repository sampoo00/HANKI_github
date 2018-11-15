package com.hanki.hanki.ShopOrder.ShopMenu;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hanki.hanki.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hanki.hanki.R.*;

public class ShopMenuDialog extends Dialog {
    private RecyclerView mReqMenuRecyclerView;
    private LinearLayoutManager mReqMenuLinearLayoutManager;
    private ShopReqMenuListAdapter mReqMenuAdapter;
//    private ArrayList<String[]> mReqMenuArrayList;
    List<ShopReqMenuData> mReqMenuList;


    public void init(){

        mReqMenuRecyclerView = (RecyclerView) findViewById(id.menu_reqRecyclerView);
        mReqMenuLinearLayoutManager = new LinearLayoutManager(getContext());
        mReqMenuLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mReqMenuRecyclerView.setLayoutManager(mReqMenuLinearLayoutManager);
        mReqMenuRecyclerView.setHasFixedSize(true);

        initArrayList();

        mReqMenuAdapter = new ShopReqMenuListAdapter(getContext(), mReqMenuList);
        mReqMenuRecyclerView.setAdapter(mReqMenuAdapter);

    }


    public ShopMenuDialog(@NonNull Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(layout.shop_menu_dialog);

        init();
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

    }


}

package com.hanki.hanki.Main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.hanki.hanki.Util.NetworkService;
import com.hanki.hanki.R;

import java.util.ArrayList;

public class SearchedShopDialog extends Dialog {

    private ImageButton searchedDialog_refreshBtn;
    private RecyclerView shopListRecyclerView;
    private ImageButton searchedDialog_closeBtn;

    public SearchedShopDialog(@NonNull Context context, final ArrayList<ShopName> shopNameList) {
        super(context);
        setContentView(R.layout.dialog_searched_shop);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        shopListRecyclerView = (RecyclerView) findViewById(R.id.shopListRecyclerView);
        shopListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final ShopNameAdapter adapter = new ShopNameAdapter(context, shopNameList);
        shopListRecyclerView.setAdapter(adapter);

        searchedDialog_closeBtn = (ImageButton) findViewById(R.id.searchedDialog_closeBtn);
        searchedDialog_closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        searchedDialog_refreshBtn = (ImageButton) findViewById(R.id.searchedDialog_refreshBtn);
        searchedDialog_refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();

            }
        });

    }

}

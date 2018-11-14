package com.hanki.hanki.ShopOrder.ShopMenu;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.hanki.hanki.R.*;

public class ShopMenuDialog extends Dialog {
    GridView reqGridList;
    GridView optGridList;
//    final String[] LIST_MENU1 = {"대", "4~6인", "26,000원"} ;
//    final String[] LIST_MENU2 = {"중", "3~4인", "20,000원"} ;

    public ShopMenuDialog(@NonNull Context context, final ArrayList<String[]> arrayList) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(layout.shop_menu_dialog);
        init(arrayList);


//참고
//        searchedDialog_closeBtn = (ImageButton) findViewById(R.id.searchedDialog_closeBtn);
//        searchedDialog_closeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });

    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//    }

    public void init(ArrayList<String[]> arrayList){
        reqGridList = (GridView) findViewById(id.menu_reqGridView);
        optGridList = (GridView) findViewById(id.menu_optGridView);
        ArrayAdapter reqAdapter;
        reqAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_single_choice, arrayList);
        reqGridList.setAdapter(reqAdapter);
        reqGridList.setChoiceMode(GridView.CHOICE_MODE_SINGLE);
        reqGridList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0: //언어 설정
                    case 1:
                    case 2:

                }
            }
        });

    }
}

package com.hanki.hanki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MypageActivity extends AppCompatActivity {

    Button mypage_saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        init();
    }

    public void init() {
        mypage_saveBtn = (Button) findViewById(R.id.mypage_saveBtn);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mypage_saveBtn: //저장버튼
                finish();
                break;
        }
    }
}

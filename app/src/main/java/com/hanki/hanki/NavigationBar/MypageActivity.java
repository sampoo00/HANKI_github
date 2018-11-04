package com.hanki.hanki.NavigationBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.hanki.hanki.R;

public class MypageActivity extends AppCompatActivity {

    Switch emailSwitch;
    Switch smsSwitch;

    DeleteAccountDialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        init();
    }

    public void init() {
        emailSwitch = (Switch) findViewById(R.id.emailSwitch);
        smsSwitch = (Switch) findViewById(R.id.smsSwitch);

        emailSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MypageActivity.this, "email", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });

        smsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MypageActivity.this, "sms", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mypage_saveBtn: //저장버튼
                finish();
                break;
            case R.id.mypage_deleteAccountBtn: //회원탈퇴버튼
                dialog = new DeleteAccountDialog(MypageActivity.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                break;
        }
    }
}

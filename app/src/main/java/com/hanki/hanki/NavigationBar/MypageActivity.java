package com.hanki.hanki.NavigationBar;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.hanki.hanki.R;

import java.text.SimpleDateFormat;
import java.util.Date;

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
                    Toast.makeText(MypageActivity.this,
                            getDate() + getResources().getString(R.string.mypage_acceptEmail), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MypageActivity.this,
                            getDate() + getResources().getString(R.string.mypage_denyEmail), Toast.LENGTH_SHORT).show();
                }
            }
        });

        smsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MypageActivity.this,
                            getDate() + getResources().getString(R.string.mypage_acceptSMS), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MypageActivity.this,
                            getDate() + getResources().getString(R.string.mypage_denySMS), Toast.LENGTH_SHORT).show();
                }
            }
        });

        final EditText mypage_phone1 = (EditText) findViewById(R.id.mypage_phone1);
        final EditText mypage_phone2 = (EditText) findViewById(R.id.mypage_phone2);
        final EditText mypage_phone3 = (EditText) findViewById(R.id.mypage_phone3);

        mypage_phone1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(mypage_phone1.length() == 3) {
                    mypage_phone2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mypage_phone2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(mypage_phone2.length() == 4) {
                    mypage_phone3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mypage_saveBtn: //저장버튼
                finish();
                break;
            case R.id.mypage_deleteAccountTv: //회원탈퇴버튼
                dialog = new DeleteAccountDialog(MypageActivity.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                break;
            case R.id.mypage_profile:
            case R.id.mypage_profile_edit: //프로필 사진 변경
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivity(intent);
                break;
        }
    }

    public String getDate() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        return sdf.format(now);
    }
}

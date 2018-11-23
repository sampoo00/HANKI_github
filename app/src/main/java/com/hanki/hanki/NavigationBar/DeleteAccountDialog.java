package com.hanki.hanki.NavigationBar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.hanki.hanki.R;

public class DeleteAccountDialog extends Dialog {

    EditText deleteAccountEt;
    Button deletionBtn;
    ImageButton cancelBtn;

    public DeleteAccountDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_delete_account);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        deleteAccountEt = (EditText) findViewById(R.id.mypage_deleteAccountEt);
        deletionBtn = (Button) findViewById(R.id.mypage_deletionBtn);
        cancelBtn = (ImageButton) findViewById(R.id.mypage_cancelBtn);

        deletionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteMessage = deleteAccountEt.getText().toString(); //사용자가 입력한 탈퇴메시지
                if(deleteMessage.equals(R.string.mypage_delete)) { //'탈퇴합니다'와 일치하였을 경우

                } else {

                }
                dismiss();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }
}

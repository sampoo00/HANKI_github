package com.hanki.hanki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanki.hanki.Tutorial.TutorialActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
//        final int checkShowTutorial = pref.getInt("checkTutorial", 0);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent;
//                if(checkShowTutorial == 0) {
//                    intent = new Intent(SplashActivity.this, TutorialActivity.class);
//                } else {
//                    intent = new Intent(SplashActivity.this, HomeActivity.class);
//                }
//                startActivity(intent);
//                finish();

                Intent intent = new Intent(SplashActivity.this, PermissionActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

}

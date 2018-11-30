package com.hanki.hanki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanki.hanki.Tutorial.TutorialActivity;

public class SplashActivity extends AppCompatActivity {
    boolean isFirstRun;
    String checkShowTutorial;
    Handler handler = new Handler();
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = getSharedPreferences("pref", MODE_PRIVATE);

        editor = pref.edit();
        isFirstRun = pref.getBoolean("isFirstRun", true);
        checkShowTutorial = pref.getString("selectedNoShow", "no");

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

                if(isFirstRun){
                    editor.putBoolean("isFirstRun", false);
                    editor.apply();
                    Intent intent = new Intent(SplashActivity.this, PermissionActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    if(checkShowTutorial.equals("no")) {
                        Intent intent = new Intent(SplashActivity.this, TutorialActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }
        }, 3000);
    }

}

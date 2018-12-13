package com.hanki.hanki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.hanki.hanki.Tutorial.TutorialActivity;

public class SplashActivity extends AppCompatActivity {
    boolean isFirstRun;
    String checkShowTutorial;
    Handler handler = new Handler();
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView app_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = getSharedPreferences("pref", MODE_PRIVATE);

        editor = pref.edit();
        //초기 값 지정
        isFirstRun = pref.getBoolean("isFirstRun", true);
        checkShowTutorial = pref.getString("selectedNoShow", "no");

        app_version = (TextView) findViewById(R.id.splash_version);
        app_version.setText("ver.1.00.01");
        LottieAnimationView lottie = (LottieAnimationView) findViewById(R.id.splash_lottie);
//        lottie.setAnimation("json/christmas_tree_with_gift_boxes.json");
        lottie.playAnimation();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

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

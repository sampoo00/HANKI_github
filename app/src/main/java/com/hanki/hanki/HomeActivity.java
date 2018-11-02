package com.hanki.hanki;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hanki.hanki.FoodTray.Fragment_FoodTray;
import com.hanki.hanki.LikeShop.Fragment_LikeShop;
import com.hanki.hanki.Main.Fragment_Home;
import com.hanki.hanki.NearByShop.Fragment_NearByShop;
import com.hanki.hanki.NumberTicket.Fragment_numberticket;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


//AppCompatActivity
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView nav_profile;
    TextView nav_mypage;
    TextView nav_logout;
    TextView nav_point;
    TextView nav_orderList;
    TextView nav_myreview;

    private Fragment_Home homeFragment;
    private Fragment_NearByShop nearByShopFragment;
    private Fragment_LikeShop likeShopFragment;
    private Fragment_numberticket numberticketFragment;
    private Fragment_FoodTray foodTrayFragment;

    boolean isFirstRun = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeFragment = new Fragment_Home();
        nearByShopFragment = new Fragment_NearByShop();
        likeShopFragment = new Fragment_LikeShop();
        numberticketFragment = new Fragment_numberticket();
        foodTrayFragment = new Fragment_FoodTray();

        initFragment(); //처음 선택된 탭이 home이여야함

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //nav_header_home.xml에서 view 가져오기
        View header = navigationView.getHeaderView(0);
        nav_profile = (ImageView) header.findViewById(R.id.nav_profile);
        nav_mypage = (TextView) header.findViewById(R.id.nav_mypage);
        nav_logout = (TextView) header.findViewById(R.id.nav_logout);
        nav_point = (TextView) header.findViewById(R.id.nav_point);
        nav_orderList = (TextView) header.findViewById(R.id.nav_orderList);
        nav_myreview = (TextView) header.findViewById(R.id.nav_myreview);



        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if (tabId == R.id.tab_home) {
                    transaction.replace(R.id.contentContainer, homeFragment).commit();
                } else if (tabId == R.id.tab_nearybyShop) {
                    transaction.replace(R.id.contentContainer, nearByShopFragment).commit();
                } else if (tabId == R.id.tab_likeShop) {
                    transaction.replace(R.id.contentContainer, likeShopFragment).commit();
                } else if (tabId == R.id.tab_numberTicket) {
                    transaction.replace(R.id.contentContainer, numberticketFragment).commit();
                } else if (tabId == R.id.tab_foodTray) {
                    transaction.replace(R.id.contentContainer, foodTrayFragment).commit();
                }

            }

        });



    }

    public boolean initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contentContainer, homeFragment);
        transaction.addToBackStack(null);
        transaction.replace(R.id.contentContainer, homeFragment).commit();
        isFirstRun = false;

        return isFirstRun;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notice) {

        } else if (id == R.id.nav_event) {

        } else if (id == R.id.nav_ads) {

        } else if (id == R.id.nav_question) {

        } else if (id == R.id.nav_setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.nav_mypage :
                intent = new Intent(HomeActivity.this, MypageActivity.class);
                break;
            case R.id.nav_logout :

                break;
            case R.id.nav_point :

                break;
            case R.id.nav_orderList :

                break;
            case R.id.nav_myreview :

                break;
        }
        startActivity(intent);
    }
}

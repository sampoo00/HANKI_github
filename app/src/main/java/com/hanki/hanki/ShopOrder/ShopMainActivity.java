package com.hanki.hanki.ShopOrder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.NetworkItem.MenuData;
import com.hanki.hanki.ShopOrder.NetworkItem.ShopResult;
import com.hanki.hanki.ShopOrder.NetworkItem.ShopTopInfo;
import com.hanki.hanki.ShopOrder.ShopMenu.Fragment_menu;
import com.hanki.hanki.Util.Application;
import com.hanki.hanki.Util.NetworkService;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.kakao.util.maps.helper.Utility.getPackageInfo;

public class ShopMainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    TabLayout mTabLayout;

    CollapsingToolbarLayout mCollapsingToolbar;
    Toolbar mToolbar;

    LikeButton likeBtn;
    TextView shopTitle;
    RatingBar shopRatingBar;
    TextView shopTxtRatingBar;
    TextView reviewNum;
    TextView pickup;
    TextView nonpickup;

    static String origin = "";
    static ArrayList<MenuData> menuList = new ArrayList<>();

    final static int TAB_NUMS = 3; //탭 갯수
    public static final String TAG = "SHOP MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_main);

        getShopResultNetwork(); //통신
        init();
        setupCollapsingToolbar();


        Log.d("HASH", getKeyHash(ShopMainActivity.this));
    }

    public void init() {
        mToolbar = (Toolbar) findViewById(R.id.shopMain_toolbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.shopMain_collapsingtoolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.shopMain_viewPager);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        shopTitle = (TextView) findViewById(R.id.shopMain_shopTitle); //매장 이름
        shopRatingBar = (RatingBar) findViewById(R.id.shopMain_ratingbar); //ratingBar
        shopTxtRatingBar = (TextView) findViewById(R.id.shopMain_txtRatingbar); //ratingBar개수를 표시하는 텍스트
        reviewNum = (TextView) findViewById(R.id.shopMain_txt_reviews);

        //pickup(픽업), nonpickup(현장)
        pickup = (TextView) findViewById(R.id.shopMain_pickup);
        nonpickup = (TextView) findViewById(R.id.shopMain_nonpickup);

        //like버튼
        likeBtn = (LikeButton) findViewById(R.id.shopMain_likeBtn);
        likeBtn.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(getApplicationContext(), "liked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Toast.makeText(getApplicationContext(), "unliked!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setupToolbar(String shopName) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(shopName); // toolbar 제목
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupCollapsingToolbar() {
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.shopMain_collapsingtoolbar);

        mCollapsingToolbar.setTitleEnabled(false);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.shop_main_fragment_menu, container, false);
            return rootView;
        }
    }


    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Fragment_menu fragment_menu = new Fragment_menu();
                    Bundle bundle = new Bundle(2);
                    bundle.putString("origin", origin);
                    bundle.putParcelableArrayList("menuList", menuList);
                    fragment_menu.setArguments(bundle);
                    return fragment_menu;
                case 1:
                    return new Fragment_shopInfo();
                case 2:
                    return new Fragment_reviews();
            }
            return null;
        }

        @Override
        public int getCount() {
            return TAB_NUMS;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // ***** 해시값 얻어오는 코드 (나중에 지울것) ***** //
    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null) return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.d("해시", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }

    public void getShopResultNetwork() {
        NetworkService networkService = Application.getInstance().getNetworkService();

        // 매장인식 다이얼로그(ShopNameAdapter)에서 넘긴 UUID와 userId 받기
        Intent intent = getIntent();
        String UUID = intent.getStringExtra("UUID");
        String userId = intent.getStringExtra("userId");

        //통신
        Call<ShopResult> request = networkService.getShopMenuResult(UUID, userId);
        request.enqueue(new Callback<ShopResult>() {
            @Override
            public void onResponse(Call<ShopResult> call, Response<ShopResult> response) {
                if (response.isSuccessful()) {
                    ShopResult shopResult = response.body();
                    setShopResult(shopResult);
                    Log.d(TAG, "메뉴판 조회 성공");
                }
            }

            @Override
            public void onFailure(Call<ShopResult> call, Throwable t) {
                Log.d(TAG, "메뉴판 조회 실패 : " + t.getMessage());
            }
        });
    }

    public void setShopResult(ShopResult shopResult) {
        if(shopResult.description.equals("success")) { //description이 success인 경우
            ShopTopInfo shopTopInfo = shopResult.result;

            setupToolbar(shopTopInfo.shopName); //툴바에 매장명 세팅
            shopTitle.setText(shopTopInfo.shopName); //매장명
            shopRatingBar.setRating(shopTopInfo.shopScoreAvg); //별점
            shopTxtRatingBar.setText(String.valueOf(shopTopInfo.shopScoreAvg)); //별점 텍스트
            reviewNum.setText("리뷰 " + String.valueOf(shopTopInfo.reviewNum)); //리뷰수

            //찜하기 여부
            if(shopTopInfo.wishYn != null && shopTopInfo.wishYn.equalsIgnoreCase("Y")) {
                likeBtn.setLiked(true);
            } else {
                likeBtn.setLiked(false);
            }

            // 매장 주문 타입 - 1: 현장/픽업, 2: 현장 only, 3: 픽업 only
            if(shopTopInfo.orderType == 1) {
                nonpickup.setBackground(getResources().getDrawable(R.color.nonPickUp_on));
                pickup.setBackground(getResources().getDrawable(R.color.pickUp_on));
            } else if(shopTopInfo.orderType == 2) {
                nonpickup.setBackground(getResources().getDrawable(R.color.nonPickUp_on));
            } else if (shopTopInfo.orderType == 3) {
                pickup.setBackground(getResources().getDrawable(R.color.pickUp_on));
            }

            origin = shopTopInfo.origin; //원산지
            menuList = shopTopInfo.list; //메뉴리스트

            Log.d(TAG, "origin : " + origin);
        }
    }
}

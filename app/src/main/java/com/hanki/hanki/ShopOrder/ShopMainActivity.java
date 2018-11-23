package com.hanki.hanki.ShopOrder;

import android.content.Context;
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
import com.hanki.hanki.ShopOrder.ShopMenu.Fragment_menu;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    final static int TAB_NUMS = 3; //탭 갯수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_main);

        init();
        setupToolbar();
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

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("매장 이름"); // toolbar 제목
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
                    return new Fragment_menu();
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
}

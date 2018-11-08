package com.hanki.hanki.ShopOrder;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanki.hanki.R;

public class ShopMainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    TabLayout mTabLayout;

    CollapsingToolbarLayout mCollapsingToolbar;
    Toolbar mToolbar;
    NestedScrollView mScrollView;

    final static int TAB_NUMS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_main);

        init();
        setupToolbar();
        setupCollapsingToolbar();


    }


    public void init(){

        mToolbar = (Toolbar) findViewById(R.id.shopMain_toolbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.shopMain_collapsingtoolbar);
        mScrollView = (NestedScrollView) findViewById(R.id.shopMain_scrollview);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.shopMain_viewPager);

        mViewPager.setAdapter(mSectionsPagerAdapter);



        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("매장 이름");
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
            View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
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

}

package com.hanki.hanki.NearByShop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanki.hanki.R;

public class Fragment_NearByShop extends Fragment {

    public Fragment_NearByShop() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_nearbyshop, container, false);
        return view;
    }
}

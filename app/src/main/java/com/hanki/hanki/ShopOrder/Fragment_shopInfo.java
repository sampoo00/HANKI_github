package com.hanki.hanki.ShopOrder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanki.hanki.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class Fragment_shopInfo extends Fragment {

    TextView shopInfo_runTime;
    TextView shopInfo_breakTime;
    TextView shopInfo_holiday;
    TextView shopInfo_phoneNum;
    RelativeLayout shopInfo_mapview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_main_fragment_shop_info, container, false);
        shopInfo_runTime = (TextView) view.findViewById(R.id.shopInfo_runTime);
        shopInfo_breakTime = (TextView) view.findViewById(R.id.shopInfo_breakTime);
        shopInfo_holiday = (TextView) view.findViewById(R.id.shopInfo_holiday);
        shopInfo_phoneNum = (TextView) view.findViewById(R.id.shopInfo_phoneNum);
        shopInfo_mapview = (RelativeLayout) view.findViewById(R.id.shopInfo_mapview);

        setMapView();

        TextView shopInfo_location = (TextView) view.findViewById(R.id.shopInfo_location);
        shopInfo_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카카오맵이 설치되어있을 경우
                //String shopLatitude = "37.5511694";
                //String shopLongitude = "126.98822659999996";
                //String url = "daummaps://look?p=" + shopLatitude + "," + shopLongitude;
                //String url = "daummaps://place?id=" + "7813422";

                // 카카오맵이 설치되어 있지 않을 경우
                String shopName = "충무로역";
                String url = "https://m.map.daum.net/actions/searchView?q=" + shopName;
                Log.d("MAP", "Map url : " + url);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SpannableString content = new SpannableString("031-123-1234");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        shopInfo_phoneNum.setText(content);

        shopInfo_phoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + shopInfo_phoneNum.getText().toString()));
                startActivity(intent);
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    public void setMapView() {
        MapView mapView = new MapView(getActivity());
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5609739, 126.99352870000007), true); //지도 중심점 변경

        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("교촌치킨 서초점");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.5609739, 126.99352870000007));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        mapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        shopInfo_mapview.addView(mapView);
    }
}

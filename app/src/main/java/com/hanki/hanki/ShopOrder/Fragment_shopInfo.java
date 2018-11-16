package com.hanki.hanki.ShopOrder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanki.hanki.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class Fragment_shopInfo extends Fragment {

    TextView shopInfo_runTime;
    TextView shopInfo_breakTime;
    TextView shopInfo_holiday;
    TextView shopInfo_phoneNum;
    Button shopInfo_dialBtn;
    RelativeLayout shopInfo_mapview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_main_fragment_shop_info, container, false);
        shopInfo_runTime = (TextView) view.findViewById(R.id.shopInfo_runTime);
        shopInfo_breakTime = (TextView) view.findViewById(R.id.shopInfo_breakTime);
        shopInfo_holiday = (TextView) view.findViewById(R.id.shopInfo_holiday);
        shopInfo_phoneNum = (TextView) view.findViewById(R.id.shopInfo_phoneNum);
        shopInfo_dialBtn = (Button) view.findViewById(R.id.shopInfo_dialBtn);
        shopInfo_mapview = (RelativeLayout) view.findViewById(R.id.shopInfo_mapview);

        setMapView();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopInfo_dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + shopInfo_phoneNum.getText().toString()));
                startActivity(intent);
            }
        });
    }

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

        shopInfo_mapview.addView(mapView);
    }
}

package com.hanki.hanki.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hanki.hanki.R;
import com.hanki.hanki.ShopOrder.Fragment_menu;
import com.hanki.hanki.ShopOrder.ShopMainActivity;
import com.minew.beacon.BeaconValueIndex;
import com.minew.beacon.BluetoothState;
import com.minew.beacon.MinewBeacon;
import com.minew.beacon.MinewBeaconManager;
import com.minew.beacon.MinewBeaconManagerListener;

import java.util.ArrayList;
import java.util.List;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class Fragment_Home extends Fragment {
    Button goShopMain;
    Button startSearchBtn;
    PrettyDialog bluetoothDialog = null;

    private MinewBeaconManager minewBeaconManager;
    private boolean isScanning;

    ArrayList<ShopData> shopNameList = new ArrayList<>();

    public Fragment_Home() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (minewBeaconManager == null) {
            minewBeaconManager = MinewBeaconManager.getInstance(getActivity());
        }

        goShopMain = (Button) view.findViewById(R.id.goShopMain);
        goShopMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShopMainActivity.class);
                startActivity(intent);
            }
        });


        startSearchBtn = (Button) view.findViewById(R.id.startSearchBtn); //비콘 인식 버튼
        startSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBluetooth() == 0) {
                    startSearch();
                } else {
                    showBluetoothDialog(); //블루투스 다이얼로그
                }
            }
        });
    }

    public int checkBluetooth() {
        BluetoothState bluetoothState = minewBeaconManager.checkBluetoothState();
        if (bluetoothState == BluetoothState.BluetoothStatePowerOn) { //연결되어 있을 때
            return 0;
        } else {
            return 1;
        }
    }

    public void showBluetoothDialog() {
        bluetoothDialog = new PrettyDialog(getActivity());
        bluetoothDialog.setMessage(getResources().getString(R.string.home_bluetoothMessage))
                .setIcon(R.drawable.bluetooth_logo)
                .setIconTint(R.color.colorPrimary)
                .addButton("확인",
                        R.color.pdlg_color_white,
                        R.color.colorPrimary,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                bluetoothDialog.dismiss();
                            }
                        })
                .setCanceledOnTouchOutside(false);
        bluetoothDialog.show();
    }

    public void startSearch() {
        startScan();

        SearchedShopDialog searchedShopDialog = new SearchedShopDialog(getActivity(), shopNameList);
        searchedShopDialog.setCanceledOnTouchOutside(false);
        searchedShopDialog.show();
    }

    public void startScan() {
        minewBeaconManager.startScan();
        isScanning = true;

        minewBeaconManager.setDeviceManagerDelegateListener(new MinewBeaconManagerListener() {
            @Override
            public void onAppearBeacons(List<MinewBeacon> list) {
                ShopData shopData;
                for (int i = 0; i < list.size(); i++) {
                    shopData = new ShopData(list.get(i).getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Minor).getStringValue());
                    if (shopData.getShopName().equals("15290") || shopData.getShopName().equals("15282")) {
                        if (!shopNameList.contains(shopData)) {
                            shopNameList.add(shopData);
                        }
                    }
                }
            }

            @Override
            public void onDisappearBeacons(List<MinewBeacon> list) {

            }

            @Override
            public void onRangeBeacons(List<MinewBeacon> list) {

            }

            @Override
            public void onUpdateState(BluetoothState bluetoothState) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isScanning)
            minewBeaconManager.stopScan();
    }
}

package com.hanki.hanki.Util;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class TaskService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        offBluetooth();
        stopSelf();
    }

    public void offBluetooth() { //앱 종료시 블루투스가 켜져 있다면 자동 끄기
        BluetoothService bluetoothService = new BluetoothService();
        if(bluetoothService.getBluetoothAdapter().isEnabled()) {
           bluetoothService.disableBluetooth();
        }
    }
}

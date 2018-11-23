package com.hanki.hanki.Util;

import android.bluetooth.BluetoothAdapter;

public class BluetoothService {

    private BluetoothAdapter bluetoothAdapter;

    public BluetoothService() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public BluetoothAdapter getBluetoothAdapter() {
        return bluetoothAdapter;
    }

    public boolean getDeviceState() {
        if (bluetoothAdapter == null) {
            return false;
        } else {
            return true;
        }
    }

    public void enableBluetooth() {
        if (bluetoothAdapter != null) {
            bluetoothAdapter.enable();
        }
    }

    public void disableBluetooth() {
        if (bluetoothAdapter != null) {
            bluetoothAdapter.disable();
        }
    }
}

package com.dfms.android7;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Long° Engagement on 2018/12/20.
 */

public class BroadcastService extends Service {
    private BroadcastReceiver receiver;

    private final String TAG = "BroadcastService";

    public BroadcastService() {
    }

    @Override
    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MainActivity.ACTION);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e(TAG, "BroadcastService接收到了广播");
            }
        };
        registerReceiver(receiver, intentFilter);
        Log.e(TAG, "BroadcastService注册了接收器");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.e(TAG, "BroadcastService取消注册接收器");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}

package com.dfms.android7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Long° Engagement on 2018/12/19.
 */

public class mBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "NormalReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("Msg");
        Log.d(TAG, msg);
    }
}

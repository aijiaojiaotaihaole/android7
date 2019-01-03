package com.dfms.android7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public TextView sectv, tva;
    Button secbtn;
    private MyBroadCastReceiverTalk receiverTalk;
    public static final String ALLTALKS = "alltalk_update";
    BroadcastReceiver mRefreshBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secbtn = findViewById(R.id.secbtn);
        sectv = findViewById(R.id.sectv);
        sectv.setText(this.toString());
        tva = findViewById(R.id.tva);
        secbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

         mRefreshBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("action.refreshFriend"))
                {
                    // reFreshFrinedList();
                    Log.d("DCFVG", "我接收到了");

                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.refreshFriend");
        registerReceiver(mRefreshBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (receiverTalk == null) {
            receiverTalk = new MyBroadCastReceiverTalk();
           /* registerReceiver(receiverTalk, new IntentFilter(ALLTALKS));
            registerReceiver(receiverTalk, new IntentFilter(ALLTALKS));*/
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ALLTALKS);
            registerReceiver(receiverTalk, intentFilter);
        }
    }
    private class MyBroadCastReceiverTalk extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("DCFVG", "我接收到了");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiverTalk != null) {
            unregisterReceiver(receiverTalk);
            receiverTalk = null;
        }
    }
}

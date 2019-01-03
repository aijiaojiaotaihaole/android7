package com.dfms.android7;

import android.content.Context;
import android.widget.Toast;

import com.dfms.android7.okhttp.ConstractPort;
import com.dfms.android7.okhttp.GsonObjectCallback;
import com.dfms.android7.okhttp.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Long° Engagement on 2018/12/29.
 */

public class NewestModel implements ConstractPort.INewestModel {
    @Override
    public void getNewstData(String url, final Context context, final NewestModel.ICallback iCallback) {
        OkHttp3Utils.doGet(url, new GsonObjectCallback<LingQuBean>() {
            @Override
            public void onUi(LingQuBean lingQuBean) {
                if (lingQuBean != null) {
                   iCallback.setData(lingQuBean);
                }else{
                    Toast.makeText(context,"请求数据为空",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                Toast.makeText(context,"请求数据失败",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public interface ICallback{
        void setData(LingQuBean newestBean);
    }
}

package com.dfms.android7;

import android.content.Context;

import com.dfms.android7.okhttp.ConstractPort;

import java.lang.ref.WeakReference;

/**
 * Created by Long° Engagement on 2018/12/29.
 */

public class NewestPresenter implements ConstractPort.INewestPressenter {
    private Context context;
    private ConstractPort.INewestModel iNewesModel;
    public WeakReference<ConstractPort.INewestView> mRefView;

    public NewestPresenter(Context context,Main4Activity main4Activity) {
        this.context = context;
        attach((ConstractPort.INewestView) main4Activity);
        this.iNewesModel =  new NewestModel();
    }
    public void attach(ConstractPort.INewestView view) {
        mRefView = new WeakReference<>(view);
    }
    public void Dttach(ConstractPort.INewestView view) {
        mRefView.clear();
    }

    @Override
    public void getData(String url) {
        iNewesModel.getNewstData(url, context, new NewestModel.ICallback() {
            @Override
            public void setData(LingQuBean newestBean) {
                mRefView.get().setNewestData(newestBean);
            }
        });
    }
}

package com.dfms.android7.okhttp;

import android.content.Context;

import com.dfms.android7.LingQuBean;
import com.dfms.android7.NewestModel;

/**
 * Created by Long° Engagement on 2018/12/29.
 */

public interface ConstractPort {
    //View层
    interface INewestView{
        void setNewestData(LingQuBean bean);
    }
    //Model层
    interface INewestModel{

        void getNewstData(String url, Context context, NewestModel.ICallback iCallback);
    }
    //Pressenter层
    interface INewestPressenter{

        void getData(String url);
    }
}

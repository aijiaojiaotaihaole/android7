package com.dfms.android7;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.dfms.android7.okhttp.ConstractPort;

import java.io.File;

public class Main4Activity extends AppCompatActivity implements ConstractPort.INewestView{
Button tijiaoa;
    NewestPresenter newestPresenter;
String url = "http://app.easteat.com/home/my/submitphone?user_id=100408&phonenum=13141296565";
//
    SubsamplingScaleImageView subsamplingScaleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tijiaoa = findViewById(R.id.tijiaoa);
        subsamplingScaleImageView = findViewById(R.id.subsampling_scale_image_view);
        newestPresenter   =new NewestPresenter(Main4Activity.this,this);
        tijiaoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newestPresenter.getData(url);

            }
        });
        Glide.with(Main4Activity.this).load("http://cdn.easteat.com/jq8u163c_3ko76tjgpizj5c26d85f72dfe.jpg").downloadOnly(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                subsamplingScaleImageView.setImage(ImageSource.uri(resource.getAbsolutePath()),
                        new ImageViewState(1.0f, new PointF(0, 0), 0));
            }
        });

    }

    @Override
    public void setNewestData(final LingQuBean bean) {
        if (bean.equals("success")){
            Toast.makeText(Main4Activity.this,"领取成功",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Main4Activity.this,bean.getData().toString(),Toast.LENGTH_SHORT).show();

        }
    }
}

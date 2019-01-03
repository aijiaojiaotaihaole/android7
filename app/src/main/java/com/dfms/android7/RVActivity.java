package com.dfms.android7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cy.cyrvadapter.adapter.RVAdapter;
import com.cy.cyrvadapter.recyclerview.VerticalRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RVActivity extends BaseActivity {
    RecyclerView rva;
    private List<MoreTypeBean> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        rva = findViewById(R.id.rva);
        mData = new ArrayList<>();
//        随机数 用来标记item界面的类型
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            MoreTypeBean  moreTypeBean = new MoreTypeBean();
            moreTypeBean.type = random.nextInt(3);
            moreTypeBean.name = "东方美食"+i;
            mData.add(moreTypeBean);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rva.setLayoutManager(linearLayoutManager);
        Recycler_variety_Adapter adapter = new Recycler_variety_Adapter(mData);
        rva.setAdapter(adapter);
    }

}

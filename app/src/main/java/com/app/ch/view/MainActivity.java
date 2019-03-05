package com.app.ch.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.ch.view.home.lable.HomeLableRecyclerviewAdapter;

public class MainActivity extends AppCompatActivity {
    static String STR_SYSINFO = "系统信息";
    static String STR_NET = "网络设置";
    static String STR_DISPLAY = "显示设置";
    static String STR_AUDIO = "音频设置";
    static String STR_TOOLS = "系统工具";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeLableRecyclerviewAdapter.addHomeLable(STR_SYSINFO, null);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_NET, null);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_DISPLAY, null);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_AUDIO, null);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_TOOLS, null);
        HomeLableRecyclerviewAdapter homeLableRecyclerview = new HomeLableRecyclerviewAdapter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.home_lable_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(homeLableRecyclerview);
    }


}

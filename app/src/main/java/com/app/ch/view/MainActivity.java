package com.app.ch.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;

import com.app.ch.view.home.lable.HomeLableRecyclerviewAdapter;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static String STR_SYSINFO = "系统信息";
    static String STR_NET = "网络设置";
    static String STR_DISPLAY = "显示设置";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String ,Object> map = new ArrayMap<>();
        map.put(STR_SYSINFO, null);
        map.put(STR_NET, null);
        map.put(STR_DISPLAY, null);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.home_lable_recyclerview);
        HomeLableRecyclerviewAdapter homeLableRecyclerview = new HomeLableRecyclerviewAdapter(map);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(homeLableRecyclerview);
    }
}

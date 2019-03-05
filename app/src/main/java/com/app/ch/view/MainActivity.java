package com.app.ch.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.widget.ListView;

import com.app.ch.view.home.lable.HomeLableRecyclerviewAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static String STR_SYSINFO = "系统信息";
    static String STR_NET = "网络设置";
    static String STR_DISPLAY = "显示设置";
    List<Map<String, Object>> homeLableMapList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedHashMap<String ,Object> map = new LinkedHashMap<>();
        packageMapFragmentToList(homeLableMapList, STR_SYSINFO, null);
        packageMapFragmentToList(homeLableMapList ,STR_NET, null);
        packageMapFragmentToList(homeLableMapList ,STR_DISPLAY, null);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.home_lable_recyclerview);
        HomeLableRecyclerviewAdapter homeLableRecyclerview = new HomeLableRecyclerviewAdapter(homeLableMapList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(homeLableRecyclerview);
    }

    private void packageMapFragmentToList(List<Map<String, Object>> mapList, String homeLable, Fragment fragment) {
        Map<String ,Object> map = new ArrayMap<>();
        map.put(HomeLableRecyclerviewAdapter.HOME_LABLE_NAME, homeLable);
        map.put(HomeLableRecyclerviewAdapter.HOME_LABLE_FRAGMENT, fragment);
        mapList.add(map);
    }
}

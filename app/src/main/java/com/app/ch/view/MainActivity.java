package com.app.ch.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.app.ch.view.fragment.FragmentAudio;
import com.app.ch.view.fragment.FragmentBackHandlerHelper;
import com.app.ch.view.fragment.FragmentDisplay;
import com.app.ch.view.fragment.FragmentNet;
import com.app.ch.view.fragment.FragmentSysInfo;
import com.app.ch.view.fragment.FragmentTools;
import com.app.ch.view.home.lable.FocusKeepRecyclerView;
import com.app.ch.view.home.lable.FocusKeepRecyclerView.FocusGainListener;
import com.app.ch.view.home.lable.HomeLableRecyclerviewAdapter;

public class MainActivity extends AppCompatActivity {
    static String STR_SYSINFO = "系统信息";
    static String STR_NET = "网络设置";
    static String STR_DISPLAY = "显示设置";
    static String STR_AUDIO = "音频设置";
    static String STR_TOOLS = "系统工具";
    FragmentSysInfo fragmentSysInfo = new FragmentSysInfo();
    FragmentNet fragmentNet = new FragmentNet();
    FragmentDisplay fragmentDisplay = new FragmentDisplay();
    FragmentAudio fragmentAudio = new FragmentAudio();
    FragmentTools fragmentSysInfo1 = new FragmentTools();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeLableRecyclerviewAdapter.addHomeLable(STR_SYSINFO, fragmentSysInfo);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_NET, fragmentNet);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_DISPLAY, fragmentDisplay);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_AUDIO, fragmentAudio);
        HomeLableRecyclerviewAdapter.addHomeLable(STR_TOOLS, fragmentSysInfo1);
        HomeLableRecyclerviewAdapter homeLableRecyclerview = new HomeLableRecyclerviewAdapter(this);

        FocusKeepRecyclerView recyclerView = findViewById(R.id.home_lable);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(homeLableRecyclerview);

        recyclerView.setGainFocusListener(new FocusGainListener() {
            @Override
            public void onFocusGain(View child, View focued) {
                Toast.makeText(child.getContext(), "获取焦点", Toast.LENGTH_SHORT).show();
                focued.setBackground(getResources().getDrawable(R.drawable.maker_btn));
            }
        });

        recyclerView.setFocusLostListener(new FocusKeepRecyclerView.FocusLostListener() {
            @Override
            public void onFocusLost(View lastFocusChild, int direction) {
                Toast.makeText(lastFocusChild.getContext(), "失去焦点", Toast.LENGTH_SHORT).show();
                lastFocusChild.setBackground(getResources().getDrawable(R.drawable.maker_btn_lost));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!FragmentBackHandlerHelper.handleBackPress(this)) {
            super.onBackPressed();
        }
    }
}

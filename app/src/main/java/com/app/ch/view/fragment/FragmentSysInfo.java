package com.app.ch.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.ch.view.R;

public class FragmentSysInfo extends MyFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sysinfo, container, false);
        refreshSysinfoToShow();
        return view;
    }

    private void refreshSysinfoToShow(){
        //实现要显示的数据，显示到界面上
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            // 每一次重新显示界面都要刷新
            refreshSysinfoToShow();
        }
    }
}

package com.app.ch.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.FocusFinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Toast;

import com.app.ch.view.R;

public class FragmentNet_wifi extends MyFragment {
    static String TAG = FragmentNet_wifi.class.getSimpleName();
    Button button;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_net_wifi, container, false);

        button = view.findViewById(R.id.btn_ip_wifi);
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
        }
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getContext(), TAG+"中按下返回键", Toast.LENGTH_SHORT).show();
        return true;
    }
}

package com.app.ch.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.ch.view.R;

public class FragmentNet extends MyFragment {
    Fragment fragmentNet_static = new FragmentNet_static();
    Fragment fragmentNet_dhcp_ = new FragmentNet_dhcp();
    Fragment fragmentNet_wifi = new FragmentNet_wifi();
    Button button_static;
    Button button_dhcp;
    Button button_wifi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net, container, false);
        button_static = view.findViewById(R.id.btn_ip_static);
        button_dhcp = view.findViewById(R.id.btn_ip_dhcp);
        button_wifi = view.findViewById(R.id.btn_ip_wifi);
        button_static.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_net, fragmentNet_static).commit();
            }
        });
        button_dhcp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_net, fragmentNet_dhcp_).commit();
            }
        });
        button_wifi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_net, fragmentNet_wifi).commit();
            }
        });
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_net, fragmentNet_static).commit();
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden && isFromHomeLable == false) {
        }
        super.onHiddenChanged(hidden);
    }
}

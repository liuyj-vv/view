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
    Fragment fragment = new FragmentNet_ethernet();
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net, container, false);
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden && isFromHomeLable == false) {
            button.requestFocus();
        }
        super.onHiddenChanged(hidden);
    }
}

package com.app.ch.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.ch.view.R;

public class FragmentNet_ethernet extends MyFragment {
    static String TAG = "FragmentNet_ethernet";
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net_ethernet, container, false);
        button = view.findViewById(R.id.back_net);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ; //弹出自己
                if (!fragmentStack.empty() && null != fragmentStack.pop()) {
                    if (!fragmentStack.empty()) {
                        switchFragment(fragmentStack.pop());
                    }
                }
            }
        });
        button.requestFocus();
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            button.requestFocus();
        }
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getContext(), TAG+"中按下返回键", Toast.LENGTH_SHORT).show();
        return true;
    }
}

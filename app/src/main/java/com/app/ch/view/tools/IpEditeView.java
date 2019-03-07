package com.app.ch.view.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.ch.view.R;

public class IpEditeView extends LinearLayout implements TextWatcher,View.OnClickListener,View.OnKeyListener {
    static String TAG = IpEditeView.class.getSimpleName();
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    View view;
    public IpEditeView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.layout_ip_edit_view, this);
        edit1 = view.findViewById(R.id.edit1);
        edit2 = view.findViewById(R.id.edit2);
        edit3 = view.findViewById(R.id.edit3);
        edit4 = view.findViewById(R.id.edit4);

        edit1.addTextChangedListener(this);
        edit2.addTextChangedListener(this);
        edit3.addTextChangedListener(this);
        edit4.addTextChangedListener(this);

        init(context);
    }

    private void init(final Context context){
        view.setBackground(getResources().getDrawable(R.drawable.maker_btn_home_lable));
        view.setFocusable(true);

        view.setOnClickListener(this);
        edit1.setOnKeyListener(this);
        edit2.setOnKeyListener(this);
        edit3.setOnKeyListener(this);
        edit4.setOnKeyListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if(edit1.getId() == getId()) {

        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == getRootView().getId()) {
            Toast.makeText(getContext(), "编辑状态", Toast.LENGTH_SHORT).show();
            edit1.requestFocus();
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if(v == edit1
            || v == edit2
            || v == edit3
            || v == edit4) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
                view.requestFocus();
            }
        }
        return false;
    }
}

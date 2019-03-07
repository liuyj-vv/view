package com.app.ch.view.tools;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.app.ch.view.R;

import java.nio.file.Watchable;

public class IpEditeView extends LinearLayout implements TextWatcher {
    static String TAG = IpEditeView.class.getSimpleName();
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    public IpEditeView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_ip_edit_view, this);
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
}

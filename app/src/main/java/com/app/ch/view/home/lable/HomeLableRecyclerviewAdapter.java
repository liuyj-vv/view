package com.app.ch.view.home.lable;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ch.view.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomeLableRecyclerviewAdapter extends RecyclerView.Adapter<HomeLableRecyclerviewAdapter.VH> {
    private final static String TAG = "HomeLableRecyclerviewAdapter";
    public final static String HOME_LABLE_NAME = "HOME_LABLE_NAME_title";
    public final static String HOME_LABLE_FRAGMENT = "HOME_LABLE_NAME_fragment";
    static List<Map<String, Object>> homeLableMapList = new ArrayList<>();

    public static void addHomeLable(String homeLable, Fragment fragment) {
        Map<String ,Object> map = new ArrayMap<>();
        map.put(HomeLableRecyclerviewAdapter.HOME_LABLE_NAME, homeLable);
        map.put(HomeLableRecyclerviewAdapter.HOME_LABLE_FRAGMENT, fragment);
        homeLableMapList.add(map);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_lable_recyclerview_item, viewGroup, false);
        view.getLayoutParams().width = viewGroup.getWidth()/getItemCount();  //一行平分宽度
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        vh.item_name.setText("" + this.homeLableMapList.get(i).get(HOME_LABLE_NAME));
        vh.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(v.getContext(), "聚焦：" + i, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.homeLableMapList != null ? this.homeLableMapList.size() : 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView item_name;
        public VH(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.home_lable_btn);

            itemView.setFocusable(true);
            itemView.setBackground(itemView.getResources().getDrawable(R.drawable.maker_btn));
        }
    }
}

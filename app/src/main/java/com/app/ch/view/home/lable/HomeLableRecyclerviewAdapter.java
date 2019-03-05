package com.app.ch.view.home.lable;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.ch.view.R;

import java.util.Map;

public class HomeLableRecyclerviewAdapter extends RecyclerView.Adapter<HomeLableRecyclerviewAdapter.VH> {
    static String TAG = "HomeLableRecyclerviewAdapter";
    Map<String,Object> map;

    public HomeLableRecyclerviewAdapter(Map<String,Object> map) {
        this.map = map;
        Log.e(TAG, HomeLableRecyclerviewAdapter.class.getName() + "map.size()" + this.map.size());

    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_lable_recyclerview_item, viewGroup, false);
        view.getLayoutParams().width = viewGroup.getWidth()/getItemCount();  //一行平分宽度
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.button.setText("" + i);
//        vh.itemView.setMinimumWidth();
    }

    @Override
    public int getItemCount() {
        return this.map != null ? this.map.size() : 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        Button button;
        public VH(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.home_lable_btn);
        }
    }
}

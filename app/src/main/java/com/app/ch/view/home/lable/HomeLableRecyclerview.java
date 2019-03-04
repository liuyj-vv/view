package com.app.ch.view.home.lable;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class HomeLableRecyclerview extends RecyclerView.Adapter<HomeLableRecyclerview.VH> {
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}

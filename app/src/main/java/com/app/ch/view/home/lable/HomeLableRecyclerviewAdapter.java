package com.app.ch.view.home.lable;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        vh.item_name.setText("" + i);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "按下：" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.map != null ? this.map.size() : 0;
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

package com.app.ch.view.home.lable;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.ch.view.R;
import com.app.ch.view.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeLableRecyclerviewAdapter extends RecyclerView.Adapter<HomeLableRecyclerviewAdapter.VH> {
    private final static String TAG = "HomeLableRecyclerviewAdapter";
    public final static String HOME_LABLE_NAME = "HOME_LABLE_NAME_title";
    public final static String HOME_LABLE_FRAGMENT = "HOME_LABLE_NAME_fragment";
    static List<Map<String, Object>> homeLableMapList = new ArrayList<>();
    AppCompatActivity activity;

    public HomeLableRecyclerviewAdapter(AppCompatActivity activity) {
        this.activity = activity;
    }

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
        final Fragment fragment = (Fragment) this.homeLableMapList.get(i).get(HOME_LABLE_FRAGMENT);

        vh.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (null != fragment) {
                        switchFragment(fragment);
                    }
                }
            }
        });
    }

    private void switchFragment(Fragment fragmentTo) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        if(MyFragment.fragmentCurr == fragmentTo) {
            return;
        }

        if (fragmentTo.isAdded()) {
            transaction.show(fragmentTo);
        } else {
            transaction.add(R.id.home_fragment, fragmentTo).show(fragmentTo);
        }

        if (null != MyFragment.fragmentCurr) {
            transaction.hide(MyFragment.fragmentCurr);
        }

        transaction.commit();
        MyFragment.fragmentCurr = fragmentTo;
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

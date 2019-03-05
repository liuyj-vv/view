package com.app.ch.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.app.ch.view.R;

import java.util.Stack;

public class MyFragment extends Fragment {
    public static Stack<Fragment> fragmentStack = new Stack<>();
    public static Fragment fragmentCurr = null;
    public int flagSiwtchFromRecyclerview = 0;  //标志当前切换进入 fragment 的方式

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            flagSiwtchFromRecyclerview = 0;
        }
    }

    public void switchFragment(Fragment fragmentTo) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if(fragmentCurr == fragmentTo) {
            return;
        }

        if (fragmentTo.isAdded()) {
            transaction.show(fragmentTo);
        } else {
            transaction.add(R.id.home_fragment, fragmentTo).show(fragmentTo);
        }

        if (null != fragmentCurr) {
            transaction.hide(fragmentCurr);
        }

        transaction.commit();
        fragmentCurr = fragmentTo;
        fragmentStack.push(fragmentTo);
    }
}

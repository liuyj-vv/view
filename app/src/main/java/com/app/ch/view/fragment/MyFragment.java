package com.app.ch.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.app.ch.view.R;

import java.util.Stack;

public class MyFragment extends Fragment implements FragmentBackHandlerInterface{
    public static Stack<Fragment> fragmentStack = new Stack<>();
    public static Fragment fragmentCurr = null;
    public static boolean isFromHomeLable = true;  //标志当前切换进入 fragment 的方式

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isFromHomeLable = false;
    }

    public void switchFragment(Fragment fragmentTo) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if(fragmentCurr == fragmentTo) {
            return;
        }

        if (fragmentTo.isAdded()) {
            transaction.show(fragmentTo);
        } else {
            transaction.add(R.id.fragment_home, fragmentTo).show(fragmentTo);
        }

        if (null != fragmentCurr) {
            transaction.hide(fragmentCurr);
        }

        transaction.commit();
        fragmentCurr = fragmentTo;
        fragmentStack.push(fragmentTo);
    }

    /*
    *   重写时
    *   返回 return super.onBackPressed(); 处理返回键后还会继续处理。
    *   返回 return true; 拦截返回键。
    * */
    @Override
    public boolean onBackPressed() {
        return FragmentBackHandlerHelper.handleBackPress(this);
    }
}

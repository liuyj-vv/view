package com.app.ch.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.app.ch.view.R;

public class MyFragment extends Fragment {
    public static Fragment fragmentCurr = null;
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
    }
}

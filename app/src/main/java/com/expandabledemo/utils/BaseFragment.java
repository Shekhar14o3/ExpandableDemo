package com.expandabledemo.utils;


import android.support.v4.app.Fragment;

import com.expandabledemo.interfaces.IOnBackPressed;


/**
 * Created by TechnoBlogger on 27/1/16.
 */

public class BaseFragment extends Fragment implements IOnBackPressed {

    @Override
    public boolean onBackPressed() {
        return true;
    }
}

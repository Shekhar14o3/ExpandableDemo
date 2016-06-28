package com.expandabledemo;

import android.app.Application;
import android.support.v4.app.FragmentActivity;

import com.expandabledemo.utils.FlowOrganizer;


/**
 * Created by Techno Blogger on 1/6/16.
 */

public class SingletonApp extends Application {
    private FragmentActivity fragmentActivity;
    private FlowOrganizer flowOrganizer;
    private static SingletonApp singletonApp;
    private MainActivity mainActivity;

    public void onDestroy() {
        fragmentActivity = null;
        flowOrganizer = null;
    }

    public void initActivity(FragmentActivity _activity) {
        this.fragmentActivity = _activity;
    }

    public FragmentActivity getFragmentActivityInstance() {
        return fragmentActivity;
    }

    public MainActivity getActivityInstanse() {
        return mainActivity;
    }

    public static SingletonApp getSingleton() {
        if (singletonApp == null)
            singletonApp = new SingletonApp();
        return singletonApp;
    }

    public void initFlowManager(int idParentFameView, FragmentActivity _activity) {
        flowOrganizer = new FlowOrganizer(_activity, idParentFameView);
    }

    public FlowOrganizer getFlowInstanse() {
        if (flowOrganizer == null) {
            flowOrganizer = new FlowOrganizer(fragmentActivity, R.id.frame_container);
        }
        return flowOrganizer;
    }
}
package com.expandabledemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;

import com.expandabledemo.fragment.FragmentMain;
import com.expandabledemo.utils.BaseFragment;

import java.util.List;


/**
 * Created by Techno Blogger on 1/6/16.
 */
public class MainActivity extends FragmentActivity {
    private int _backBtnCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SingletonApp.getSingleton().initActivity(this);
        SingletonApp.getSingleton().getFlowInstanse().add(new FragmentMain(), false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (getSupportFragmentManager() != null) {
            List<Fragment> list = getSupportFragmentManager().getFragments();
            if (list == null)
                return;
            for (Fragment f : list) {
                if (f != null)
                    f.onLowMemory();
            }
        }
    }


    @Override
    public void onBackPressed() {

        boolean isbaseBackPress = true;

        SingletonApp.getSingleton();
        if (SingletonApp.getSingleton().getFlowInstanse() != null) {
            List<Fragment> list = getSupportFragmentManager().getFragments();
            if (list != null) {
                for (Fragment fragment : list) {
                    if (fragment instanceof BaseFragment) {
                        isbaseBackPress = ((BaseFragment) fragment).onBackPressed();
                    }
                }
            }
        }

        if (!isbaseBackPress)
            return;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                _backBtnCount = 0;
            }
        }, 1000);

        if (!SingletonApp.getSingleton().getFlowInstanse().hasNoMoreBack())
            super.onBackPressed();
        else {
            _backBtnCount++;
            if (_backBtnCount == 2) {
                System.exit(1);
                finish();
            } else {
                exitDialog();
            }
        }
    }

    public void exitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are You Sure you want to Exit? ");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    protected void onDestroy() {
        SingletonApp.getSingleton().onDestroy();
        super.onDestroy();
    }
}

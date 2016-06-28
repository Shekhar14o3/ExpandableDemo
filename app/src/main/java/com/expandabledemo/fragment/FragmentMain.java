package com.expandabledemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.expandabledemo.R;
import com.expandabledemo.adapter.AdapterExpandable;
import com.expandabledemo.utils.BaseFragment;

/**
 * Created by Techno Blogger on 1/6/16.
 */
public class FragmentMain extends BaseFragment {
    public ExpandableListView expandableListActivity;
    private int prevPosition = -1;
    private AdapterExpandable adapterExpandable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        expandableListActivity = (ExpandableListView) rootView.findViewById(android.R.id.list);
        adapterExpandable = new AdapterExpandable(getActivity(), inflater);

        // For one option at a time

        expandableListActivity.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListActivity.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

        return rootView;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        expandableListActivity = (ExpandableListView) view.findViewById(android.R.id.list);

        adapterExpandable = new AdapterExpandable(getActivity(), getLayoutInflater(getArguments()));
        expandableListActivity.setAdapter(adapterExpandable);
    }
}

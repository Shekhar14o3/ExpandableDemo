package com.expandabledemo.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.expandabledemo.R;
import com.expandabledemo.interfaces.IAllConstants;

/**
 * Created by Techno Blogger on 1/6/16.
 */

public class AdapterExpandable implements ExpandableListAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public AdapterExpandable(Context context, LayoutInflater layoutInflater) {
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        View v = null;

        // To call child layouts -----

        if (groupPosition == 0) {
            v = View.inflate(context, R.layout.child_name, null);
        }
        if (groupPosition == 1) {
            v = View.inflate(context, R.layout.child_gender, null);
        }
        if (groupPosition == 2) {

            v = View.inflate(context, R.layout.child_address, null);
            TextView textView = (TextView) v.findViewById(R.id.txtAddress);
            textView.setText(IAllConstants.address);
        }
        if (groupPosition == 3) {
            v = View.inflate(context, R.layout.child_favfood, null);
        }


        v.invalidate();
        return v;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return 4;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        View v = convertView.inflate(context, R.layout.expandable_header, null);
        TextView txtView = (TextView) v.findViewById(R.id.headerText);
        ImageView imageView = (ImageView) v.findViewById(R.id.icon);

        ImageView imageToggle = (ImageView) v.findViewById(R.id.foldButton);

        // For Managing the Toggle Icon

        if (isExpanded) {
            imageToggle.setImageResource(R.drawable.accordion_minus);
        } else {
            imageToggle.setImageResource(R.drawable.accordion_plus);
        }

        // Heading of the Parent Layout

        if (groupPosition == 0) {
            txtView.setText("NAME");
            txtView.setTextSize(15f);

            imageView.setImageResource(R.drawable.icon_card_user);
        }
        if (groupPosition == 1) {
            txtView.setText("GENDER");
            txtView.setTextSize(15f);
            imageView.setImageResource(R.drawable.icon_card_user);
        }
        if (groupPosition == 2) {
            txtView.setText("ADDRESS");
            txtView.setTextSize(15f);
            imageView.setImageResource(R.drawable.icon_card_user);
        }
        if (groupPosition == 3) {
            txtView.setText("FAV FOOD");
            txtView.setTextSize(15f);
            imageView.setImageResource(R.drawable.icon_card_user);
        }

        v.invalidate();
        return v;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }


    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

}
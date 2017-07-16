package com.finance.Adapters;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.finance.R;


public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private String[] items;
    private int highlightPosition = 0;
    private View.OnClickListener onClickListener;

    public NavDrawerListAdapter(Context context, String[] items, View.OnClickListener onClickListener) {
        this.context = context;
        this.items = items;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_navigation_drawer_item, parent,false);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.tvDrawerTitle);
        txtTitle.setText(items[position]);
        if (highlightPosition == position) {
            txtTitle.setTextColor(context.getResources().getColor(R.color.gold));
        } else {
            txtTitle.setTextColor(context.getResources().getColor(R.color.gold));
        }
        convertView.setTag(items[position]);
        convertView.setOnClickListener(onClickListener);
        return convertView;
    }

    public int getHighlightPosition() {
        return highlightPosition;
    }

    public void setHighlightPosition(int highlightPosition) {
        this.highlightPosition = highlightPosition;
    }

}

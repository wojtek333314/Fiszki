package com.brotherhood.englishfiche.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.brotherhood.fiche.R;

public class RowAdapter extends ArrayAdapter<RowBean> {

    Context         context;
    RowBean         data[] = null;
    int             layoutResourceId;


    public RowAdapter(Context context, int layoutResourceId, RowBean[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RowBeanHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RowBeanHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.checkbox = (CheckBox)row.findViewById(R.id.check);

            row.setTag(holder);
        }
        else
        {
            holder = (RowBeanHolder)row.getTag();
        }

        RowBean object = data[position];
        holder.txtTitle.setText(object.title);
        holder.checkbox.setChecked(object.check);

        return row;
    }

    static class RowBeanHolder
    {
        TextView txtTitle;
        CheckBox checkbox;
    }
}
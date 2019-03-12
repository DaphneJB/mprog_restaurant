package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuItemAdapter extends ArrayAdapter<String> {
    private ArrayList<String> menu;

    public MenuItemAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
         menu = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView text = convertView.findViewById(R.id.categories);
        text.setText(menu.get(position));
        return convertView;

    }
}


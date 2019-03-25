package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
//Represents an adapter that takes a list of menu items and formats it to display
public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private ArrayList<MenuItem> menu;

    public MenuAdapter(Context context, int resource, ArrayList<MenuItem> objects) {
        super(context, resource, objects);
        menu = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        }
        //set name of dish
        TextView name = convertView.findViewById(R.id.name);
        name.setText(menu.get(position).getName());
        //set price
        TextView price = convertView.findViewById(R.id.price);
        price.setText("€" + menu.get(position).getPrice());
        //set image
        ImageView imageView = convertView.findViewById(R.id.image);
        Picasso.with(getContext()).load(menu.get(position).getImageUrl()).into(imageView);
        return convertView;
    }
}

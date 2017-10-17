package com.example.eslam.accapp.entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.eslam.accapp.R;

import java.util.ArrayList;

/**
 * Created by Eslam on 10/16/2017.
 */

public class IncomingAdabter extends BaseAdapter {
    ArrayList<IncomingEntity> list;
    Context c;

    public IncomingAdabter(ArrayList<IncomingEntity> list, Context c) {
        this.list = list;
        this.c = c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.model, null);
        }
        TextView name, price, quantity, category;
        name = (TextView) convertView.findViewById(R.id.tv_model_name);
        price = (TextView) convertView.findViewById(R.id.tv_model_price);
        quantity = (TextView) convertView.findViewById(R.id.tv_model_quantity);
        category = (TextView) convertView.findViewById(R.id.tv_model_category);
        name.setText(list.get(position).getName());
        price.setText(list.get(position).getPrice());
        quantity.setText(list.get(position).getQuantity());
        category.setText(list.get(position).getCategory());

        return convertView;
    }
}

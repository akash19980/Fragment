package com.example.user.fragments;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {
    Context context;
    int images[];
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, int[] devices)
    {
        this.context = applicationContext;
        this.images = devices;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount()
    {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflater.inflate(R.layout.activity_custom_adapter,null);
        ImageView icon = (ImageView)view.findViewById(R.id.imageView2);
        icon.setImageResource(images[i]);
        return view;
    }
}

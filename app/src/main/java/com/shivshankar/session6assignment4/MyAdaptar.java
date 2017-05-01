package com.shivshankar.session6assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Shivshankar on 14-12-2016.
 */
public class MyAdaptar extends BaseAdapter {
    Context context;
    String[] contact_name;
    String[] contact_no;
    public MyAdaptar(MainActivity mainActivity, String[] contact_name, String[] contact_no) {
        this.contact_name=contact_name;
        this.contact_no=contact_no;
        this.context=mainActivity;
    }

    @Override
    public int getCount() {
        return contact_name.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View show;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        show=inflater.inflate(R.layout.contacts,null);
        TextView name=(TextView)show.findViewById(R.id.name);
        name.setText(contact_name[i]);
        TextView no=(TextView)show.findViewById(R.id.phone_no);
        no.setText(contact_no[i]);
        return show;
    }
}

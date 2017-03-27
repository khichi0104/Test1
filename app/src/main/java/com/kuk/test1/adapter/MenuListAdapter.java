package com.kuk.test1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuk.test1.R;
import com.squareup.picasso.Picasso;

/**
 * Created by KUK on 1/3/2560.
 */

public class MenuListAdapter extends ArrayAdapter<FoodItem> {

    LayoutInflater inflater;

    public MenuListAdapter(Context context, int resource) {
        super(context, resource);

        inflater = LayoutInflater.from( context );
    }

    //มีทั้งหมด กี่แถว
   // @Override
    //public int getCount() {
     //   return 50;
    //}

    //มี Cell ทั้งหมด กี่ประเภท
    @Override
    public int getViewTypeCount() {
        return 1;
    }

    //แถวนั้นๆ เป็น View ประเภทอะไร
    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    //กำหนดหมายเลขของView แต่ละประเภท
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        if( convertView != null){
            v = convertView;
        }else{
            v = inflater.inflate( R.layout.activity_listview , parent , false );
        }

        TextView lbMenuName= (TextView)v.findViewById( R.id.lbMenuName );
        TextView lbMenuPrice= (TextView)v.findViewById( R.id.lbPrice );
        ImageView imgFood = (ImageView)v.findViewById(R.id.imgfood);

        FoodItem item = getItem(position);
        lbMenuName.setText(item.getName());
        lbMenuPrice.setText(item.getPrice()+" บาท");
        Picasso.with(getContext()).load(item.getImage()).into(imgFood);


        return v;
    }
}

package com.kuk.test1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuk.test1.R;
import com.kuk.test1.viewholder.FoodViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by KUK on 6/3/2560.
 */

public class RecycleviewAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    public List<FoodItem> items;

    public RecycleviewAdapter(){
        super();

        items = new ArrayList<>();
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_listview, parent , false );

        FoodViewHolder holder = new FoodViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        holder.setData( items.get(position) );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



}

package com.kuk.test1.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuk.test1.R;
import com.kuk.test1.database.PhotoModel;
import com.kuk.test1.viewholder.PhotoViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KUK on 23/3/2560.
 */

public class PhotoRecycleviewAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    public List<PhotoModel> photoModelList;


    public PhotoRecycleviewAdapter() {
        super();
        photoModelList = new ArrayList<>();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("photo","Start onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_photo_list,parent,false);
        PhotoViewHolder holder = new PhotoViewHolder(view);
        Log.d("photo","End onCreateViewHolder");
        return holder;
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {

        holder.setData(photoModelList.get(position));

    }

    @Override
    public int getItemCount() {
        return photoModelList.size();
    }

    public void swap(List<PhotoModel> datas) {
        //photoModelList.clear();
        //Log.d("Size",datas.size()+"");
        //photoModelList = datas;

    }
}

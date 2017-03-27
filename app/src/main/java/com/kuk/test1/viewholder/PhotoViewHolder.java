package com.kuk.test1.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuk.test1.R;
import com.kuk.test1.SQLActivity;
import com.kuk.test1.adapter.PhotoRecycleviewAdapter;
import com.kuk.test1.database.PhotoModel;
import com.kuk.test1.database.PhotoSQLite;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

/**
 * Created by KUK on 23/3/2560.
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    ImageView photoImgView;
    TextView txtPath;
    TextView txtDate;
    Button btnDel;

    PhotoModel data;



    public PhotoViewHolder(final View itemView) {
        super(itemView);

        photoImgView = (ImageView) itemView.findViewById(R.id.photoImgView);
        txtPath = (TextView)itemView.findViewById(R.id.txtpath);
        txtDate = (TextView)itemView.findViewById(R.id.txtdate);
        btnDel =(Button)itemView.findViewById(R.id.btndeletephoto);



        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = data.getId();
                String path = data.getPath();
                Log.d("DElete*--> ",path+"");
                PhotoSQLite db = new PhotoSQLite(itemView.getContext());
                db.deletePhoto(id,path);


                List<PhotoModel> newdatas = db.getPhoto();
                PhotoRecycleviewAdapter adapter = new PhotoRecycleviewAdapter();
                //adapter.swap(newdatas);

                adapter.photoModelList = newdatas;
                Log.d("AfterDel",adapter.photoModelList.size()+"");
                adapter.notifyDataSetChanged();
            }
        });

    }

    public  void setData (PhotoModel data)
    {
        this.data = data;
        txtPath.setText(data.getPath());
        txtDate.setText(data.getDate());


        File filePath = new File(data.getPath());

        Picasso.with(itemView.getContext()).load(filePath).into(photoImgView);
        Log.d("ViewHolder","SetView+ "+data.getPath());
    }


}

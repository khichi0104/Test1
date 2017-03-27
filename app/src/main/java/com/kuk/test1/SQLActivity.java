package com.kuk.test1;

import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.kuk.test1.adapter.PhotoRecycleviewAdapter;

import com.kuk.test1.database.PhotoModel;
import com.kuk.test1.database.PhotoSQLite;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;

public class SQLActivity extends AppCompatActivity {

    Button cameraBtn;
    RecyclerView photoList;

    PhotoSQLite db;

    PhotoRecycleviewAdapter adapter;

    int CAMERA_REQUEST_CODE = 999;



   // List<PhotoModel> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        db = new PhotoSQLite(this);


        List<PhotoModel> m = db.getPhoto();
        for(int i=0; i<m.size(); i++){
            Log.d("photo" , m.get(i).getPath() );
        }

        cameraBtn = (Button) findViewById(R.id.cameraButton);
        photoList = (RecyclerView)findViewById(R.id.photoList);



        adapter = new PhotoRecycleviewAdapter();

        photoList .setAdapter(adapter);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);



        photoList .setLayoutManager(linearLayoutManager);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult( i , CAMERA_REQUEST_CODE );

            }
        });

        adapter.photoModelList = m;
        Log.d("Size",db.getPhoto().size()+"");

        adapter.notifyDataSetChanged();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK  ) {
            Bundle extras = intent.getExtras();

            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //mImageView.setImageBitmap(imageBitmap);

            String file = saveBitmapToFile(imageBitmap);
            Log.i("Capture", file);

            db.savePhoto(file);

           //adapter.swap(db.getPhoto());
            //adapter.photoModelList = db.getPhoto();

            updateData();
            adapter.notifyDataSetChanged();
        }
    }

    String saveBitmapToFile(Bitmap bitmap){
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/req_images");
        myDir.mkdirs();

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";

        File file = new File(myDir, fname);
        String fullPath = myDir + "/" + fname;

        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fullPath;
    }


    public void updateData(){
        adapter = new PhotoRecycleviewAdapter();
        photoList.setAdapter(adapter);
        adapter.photoModelList = db.getPhoto();
    }


}

package com.kuk.test1.database;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by KUK on 22/3/2560.
 */

public class PhotoModel {
    String path;
    String date;
    int id;



    public  PhotoModel (int pid, String ppath, String pdate){
        setId(pid);
        setPath(ppath);
        setDate(pdate);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

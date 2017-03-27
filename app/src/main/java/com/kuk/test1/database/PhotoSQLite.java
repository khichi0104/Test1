package com.kuk.test1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.TimeZone;
import android.util.Log;


import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by KUK on 22/3/2560.
 */

public class PhotoSQLite extends SQLiteOpenHelper {

   // private static int VERSION = 0;

    public PhotoSQLite(Context context) {
        super(context, "photo", null , 1);
    }

    public void savePhoto( String path){
        SQLiteDatabase db = getWritableDatabase();
        Log.d("photo","getDB");



        Calendar c = GregorianCalendar.getInstance();
        int d = c.get(Calendar.DATE);
        int mm = c.get(Calendar.MONTH);
        int y = c.get(Calendar.YEAR);

        int h = c.get(Calendar.HOUR);
        int m =c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);

        String date = d+"/"+mm+"/"+y+" "+h+":"+m+" "+s;

        String sql = "INSERT INTO photo (path, date) VALUES ( \""+path+"\" , \""+date+"\" )";
        Log.d("photo","insert"+ path+ " "+ date);
        db.execSQL(sql);

       // db.close();
    }


    public void deletePhoto(int id,String path){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM photo WHERE id ="+id;
        db.execSQL(sql);

        File file = new File (path);
        boolean deleted = file.delete();
        Log.d("photo","Delete: "+db.getPath());
        Log.d("photo","Result: "+deleted+"");



       // db.close();
    }

    public List<PhotoModel> getPhoto(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM photo";

        Cursor c = db.rawQuery(sql,null);

        List<PhotoModel> list = new ArrayList<>();

        if( c == null )return list;

        if( c.moveToFirst() ){
            do{
                /*PhotoModel m = new PhotoModel();

                m.setId( c.getInt(0));
                m.setPath(c.getString(1));
                m.setDate(c.getString(2));

                list.add(m);
                */

                int id = c.getInt(0);
                String path = c.getString(1);
                String date = c.getString(2);
                PhotoModel m = new PhotoModel(id,path,date);
                list.add(m);
                //list.add(new PhotoModel(id,path,date));
                Log.d("photo","getPhoto: "+m.getId()+" "+ m.getPath());
            }while( c.moveToNext() );
        }

        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE photo (id INTEGER PRIMARY KEY, path TEXT,date TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    //About upgrade DB version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

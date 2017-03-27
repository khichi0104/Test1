package com.kuk.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kuk.test1.adapter.FoodItem;
import com.kuk.test1.adapter.MenuListAdapter;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Main3Activity extends AppCompatActivity {

    ListView listView;
    MenuListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView = (ListView) findViewById(R.id.foodList);

        adapter = new MenuListAdapter(this, 0);

       /* adapter.add(new FoodItem("ต้มยำ", 500, "http://orsimages.unileversolutions.com/ORS_Images/Knorr_en-SG/tomyam_41_1.1.60_326X580.Jpeg"));
        adapter.add(new FoodItem("สปาเกตตี้", 250, "http://spaghetticrunch.com/wp-content/uploads/2014/12/spaghetti-bolognaise-1.png"));
        adapter.add(new FoodItem("คัตสึด้ง", 300, "https://robintimweis.files.wordpress.com/2012/06/katsudon6.jpg"));
        adapter.add(new FoodItem("ผัดไท", 200, "http://drinks.seriouseats.com/images/2011/11/20111103padthai.jpg"));
        adapter.add(new FoodItem("ก๋งยเตี๋ยว", 120, "http://mpics.manager.co.th/pics/Images/560000000016005.JPEG"));
        adapter.add(new FoodItem("ข้าวไข่เจียว", 70, "http://www.chingcancook.com/head_photo/2_20120616135953_201.jpg"));
        adapter.add(new FoodItem("ข้าวกะเพราไก่ไข่ดาว", 150, "http://www.khanpak.com/files/content/thumbnails/370_250/2015/content-0030195-1427162853.jpg"));
*/
        listView.setAdapter(adapter);

        loadMenuFromServer();

    }

    private void loadMenuFromServer() {

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://demo4991538.mockable.io/foodmenu", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    JSONArray menu = response.getJSONArray("menu");

                    for(int i=0; i<menu.length(); i++){

                        JSONObject m = menu.getJSONObject(i);

                        String name = m.getString("name");
                        int price = m.getInt("price");
                        String image = m.getString("image");

                        adapter.add(new FoodItem( name , price , image ));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}

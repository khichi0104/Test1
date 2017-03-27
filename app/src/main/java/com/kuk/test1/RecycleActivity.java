package com.kuk.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kuk.test1.adapter.FoodItem;
import com.kuk.test1.adapter.RecycleviewAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RecycleActivity extends AppCompatActivity {

    RecycleviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        RecyclerView rview = (RecyclerView)findViewById(R.id.rview);
        adapter = new RecycleviewAdapter();
        rview.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

       // GridLayoutManager m2 = new GridLayoutManager(this,);

        rview.setLayoutManager(linearLayoutManager);

        loadMenuFromServer();

    }

    private void loadMenuFromServer() {

        AsyncHttpClient client = new AsyncHttpClient();

        String url = getIntent().getStringExtra("url");

        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    JSONArray menu = response.getJSONArray("menu");

                    for (int i = 0; i < menu.length(); i++) {

                        JSONObject m = menu.getJSONObject(i);

                        String name = m.getString("name");
                        int price = m.getInt("price");
                        String image = m.getString("image");

                        adapter.items.add(new FoodItem(name, price, image));
                    }

                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}



package com.kuk.test1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button b;
    Button b2;
    TextView textView;
    Button btnListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);



        b =   (Button) findViewById( R.id.b2 );
        b2 = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("ABC");
            }
        });

        btnListView =(Button)findViewById(R.id.btnListView);

       final Context context = this;
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( context  ,    Main3Activity.class     );
                startActivity( i );

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "learn" , "2 on start" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "learn" , "2 on resume" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "learn" , "2 on pause" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "learn" , "2 on stop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( "learn" , "2 on destroy" );
    }

}

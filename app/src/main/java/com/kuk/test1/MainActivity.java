package com.kuk.test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.TextInputLayout;

public class MainActivity extends AppCompatActivity  {

    Button b;
    Button b2;
    Button b3;
    Button b4;
    TextView menuName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(   R.layout.activity_main    );

        b =   (Button) findViewById( R.id.b1 );

        final Context context = this;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( context  ,    Main2Activity.class     );
                startActivity( i );

            }
        });

        b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( context  ,    RecycleActivity.class     );
                i.putExtra("url" , "http://demo4991538.mockable.io/foodmenu");

                //startActivity( i );
                startActivityForResult(i , 99 );

            }
        });

       /* Click1 xxx = new Click1();
        b.setOnClickListener(xxx);
        */

        menuName = (TextView) findViewById(R.id.menuName);

        b3 =   (Button) findViewById( R.id.button3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( context  ,    FragmentActivity.class     );
                startActivity( i );

            }
        });

        b4 =   (Button) findViewById( R.id.button4);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( context  ,    SQLActivity.class     );
                startActivity( i );

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        if( requestCode == 99 ){
            if(resultCode == Activity.RESULT_OK ){

                String foodName = i.getStringExtra("name");
                menuName.setText(foodName);

            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "learn" , "1 on start" );


       Log.d("kuknoti","id ======== "+getIntent().getStringExtra("promotion_id") );

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "learn" , "1 on resume" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "learn" , "1 on pause" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "learn" , "1 on stop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( "learn" , "1 on destroy" );
    }


}


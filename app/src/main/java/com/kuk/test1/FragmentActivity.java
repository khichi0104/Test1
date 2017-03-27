package com.kuk.test1;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kuk.test1.fragment.BlankFragment;

public class FragmentActivity extends android.support.v4.app.FragmentActivity implements BlankFragment.OnFragmentInteractionListener{
TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();

        transaction.replace(R.id.frag1 , BlankFragment.newInstance("Hello 1111") );
        transaction.replace(R.id.frag2 , BlankFragment.newInstance("Hello 2222") );

        transaction.commit();

        text1 = (TextView) findViewById(R.id.text_below);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClickFragmentButton(String str){
        text1.setText(str);
    }


}

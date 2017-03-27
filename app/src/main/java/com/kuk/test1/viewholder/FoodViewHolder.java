package com.kuk.test1.viewholder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuk.test1.R;
import com.kuk.test1.adapter.FoodItem;
import com.squareup.picasso.Picasso;
import android.content.Intent;

/**
 * Created by KUK on 6/3/2560.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder {

    Button addBtn;
    TextView lbMenuName;
    TextView lbMenuPrice;
    ImageView imgFood ;

    FoodItem data;

    public FoodViewHolder(View itemView) {
        super(itemView);

        lbMenuName= (TextView)itemView.findViewById( R.id.lbMenuName );
        lbMenuPrice= (TextView)itemView.findViewById( R.id.lbPrice );
        imgFood = (ImageView)itemView.findViewById(R.id.imgfood);
        addBtn = (Button)itemView.findViewById(R.id.add_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity)v.getContext();

                Intent i = new Intent();
                i.putExtra("name" , data.getName() );

                activity.setResult( Activity.RESULT_OK , i );

                activity.finish();
            }
        });
    }

    public void setData(FoodItem data) {
        this.data = data;
        lbMenuName.setText(data.getName());
        lbMenuPrice.setText(data.getPrice()+"บาท");
        Picasso.with(itemView.getContext()).load(data.getImage()).into(imgFood);


    }
}

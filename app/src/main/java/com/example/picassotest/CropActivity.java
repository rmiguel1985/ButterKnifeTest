package com.example.picassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrador on 07/06/2016.
 */
public class CropActivity extends AppCompatActivity {

    @BindView(R.id.resize_img_center_crop)
    ImageView imgCenterCrop;
    @BindView(R.id.resize_img_inside_crop)
    ImageView imgInsideCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        ButterKnife.bind(this);


        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .resize(200, 200)
                .centerInside()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(imgInsideCrop);

        Picasso
                .with(this)
                .load(remoteUrl)
                .resize(100, 100) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(imgCenterCrop);
    }
}

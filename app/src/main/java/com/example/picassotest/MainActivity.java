package com.example.picassotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.resize_img)
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";

        // Set Loggin and indicators
        // To see  logging filter Logcat by Picasso
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(logo);
    }


    @OnClick({R.id.main_btn_resize, R.id.main_btn_crop, R.id.main_btn_rotation, R.id.main_btn_transform})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.resize_img:
                break;
            case R.id.main_btn_resize:
                Intent intentResize = new Intent(this, ResizeActivity.class);
                startActivity(intentResize);
                break;
            case R.id.main_btn_crop:
                Intent intentCrop = new Intent(this, CropActivity.class);
                startActivity(intentCrop);
                break;
            case R.id.main_btn_rotation:
                Intent intentRotation = new Intent(this, RotationActivity.class);
                startActivity(intentRotation);
                break;
            case R.id.main_btn_transform:
                Intent intentTransform = new Intent(this, TransformActivity.class);
                startActivity(intentTransform);
                break;
        }
    }
}

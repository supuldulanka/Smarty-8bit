package com.devlanka.smarty;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by Shamalka Navod on 2017-07-23.
 */


public class PlantFragment extends android.support.v4.app.Fragment {

    ProgressBar progressBar1,progressBar2,progressBar3;
    ImageView smiley;
    TextView smiley_text,water_status;
    Button refresh;

    public static PlantFragment newInstance() {
        PlantFragment fragment = new PlantFragment();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.plants_fragment, container, false);

        progressBar1 = (ProgressBar) v.findViewById(R.id.progressBar);
        //progressBar1.setProgress(60);

        progressBar2 = (ProgressBar) v.findViewById(R.id.progressBar2);
        //progressBar2.setProgress(50);

        progressBar3 = (ProgressBar) v.findViewById(R.id.progressBar3);
        //progressBar3.setProgress(90);

        smiley = (ImageView) v.findViewById(R.id.plant_smiley);
        smiley_text = (TextView) v.findViewById(R.id.plant_smiley_text);
        water_status = (TextView) v.findViewById(R.id.water_progress);


        ProgressBarAnimation anim1 = new ProgressBarAnimation(progressBar1, 1, 40);
        anim1.setDuration(1800);
        progressBar1.startAnimation(anim1);

        ProgressBarAnimation anim2 = new ProgressBarAnimation(progressBar2, 1, 80);
        anim2.setDuration(1800);
        progressBar2.startAnimation(anim2);

        ProgressBarAnimation anim3 = new ProgressBarAnimation(progressBar3, 1, 90);
        anim3.setDuration(1800);
        progressBar3.startAnimation(anim3);


        if (progressBar1.getProgress()>=75){
            smiley.setImageDrawable(getResources().getDrawable(R.drawable.smile75));
        }else if (progressBar2.getProgress()>=50){
            smiley.setImageDrawable(getResources().getDrawable(R.drawable.smile2));
        }else if (progressBar3.getProgress()>=25){
            smiley.setImageDrawable(getResources().getDrawable(R.drawable.sad50));
        }else{
            smiley.setImageDrawable(getResources().getDrawable(R.drawable.sad25));
        }

        refresh = (Button) v.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ProgressBarAnimation anim1 = new ProgressBarAnimation(progressBar1, 1, 100);
                anim1.setDuration(1800);
                progressBar1.startAnimation(anim1);
                smiley.setImageDrawable(getResources().getDrawable(R.drawable.smile75));
                smiley_text.setText("Thank You!");
                water_status.setText("Perfect");

            }
        });

        return v;
    }


}

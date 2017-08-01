package com.devlanka.smarty;

/**
 * Created by supuldulanka on 7/23/17.
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A demo class that stores and retrieves data objects with each marker.
 */
public class MarkerDemoActivity extends FragmentActivity implements
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback {

    private Marker plant1,plant2,plant3,plant4,plant5,plant6;
    private int plant1_img,plant2_img,plant3_img,plant4_img,plant5_img,plant6_img;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /** Called when the map is ready. */
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);


        plant1_img = R.drawable.plant1_icon;
        plant2_img = R.drawable.plant2_icon;
        plant3_img = R.drawable.plant3_icon;
        plant4_img = R.drawable.plant4_icon;
        plant5_img = R.drawable.plant5_icon;
        plant6_img = R.drawable.plant6_icon;

        plant1 = CreatePlant("Plant No:1",18.358302, 80.486606,plant1_img);
        plant2 = CreatePlant("Plant No:2",18.354302, 80.480606,plant2_img);
        plant3 = CreatePlant("Plant No:3",18.350480, 80.485570,plant3_img);
        plant4 = CreatePlant("Plant No:4",18.350480, 80.485570,plant4_img);
        plant5 = CreatePlant("Plant No:5",18.350480, 80.485570,plant5_img);
        plant6 = CreatePlant("Plant No:6",18.350480, 80.485570,plant6_img);
        plant1.setVisible(false);
        plant2.setVisible(false);
        plant3.setVisible(false);
        plant4.setVisible(false);
        plant5.setVisible(false);
        plant5.setVisible(false);


        Integer supul_img = R.drawable.pointer_supul;
        Integer shamalka_img = R.drawable.pointer_shamalka;
        Integer lalanga_img = R.drawable.pointer_lalanga;
        Integer chashika_img = R.drawable.pointer_chashika;
        Integer pasindu_img = R.drawable.pointer_pasindu;

        // Add some markers to the map, and add a data object to each marker.

        Marker supul = CreateGarden("Supul's Garden",new LatLng(8.356302, 80.484606),10000,supul_img);
        Marker shamalka = CreateGarden("Shamalka's Garden",new LatLng(8.108242, 80.900188),15000,shamalka_img);
        Marker chashika = CreateGarden("Chashika's Garden",new LatLng(7.047637, 81.122146),24000,chashika_img);
        Marker pasindu = CreateGarden("Pasindu's Garden",new LatLng(6.343857, 80.495925),14000,pasindu_img);
        Marker lalanga = CreateGarden("Lalanga's Garden",new LatLng(7.117311, 80.103679),45000,lalanga_img);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(8.356302, 80.484606), 11));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                float zoomLevel = mMap.getCameraPosition().zoom;
                int zoomInt = Math.round(zoomLevel);
                Log.d("sssss", String.valueOf(zoomInt));
                if (zoomInt < 10){
                    plant1.setVisible(false);
                    plant2.setVisible(false);
                    plant3.setVisible(false);
                    plant4.setVisible(false);
                    plant5.setVisible(false);
                    plant6.setVisible(false);

                }
            }
        });
    }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        String clicked_name = marker.getTitle();
        Integer tag_name = (Integer) marker.getTag();
        String marker_id = marker.getId();
        String snippet = marker.getSnippet();
        Log.d("ssss", marker_id);
        //Log.d("sssss", String.valueOf(tag_name));

        // Check if a click count was set, then display the click count.
        if (clicked_name != null && snippet != null) {

            double pos1 = marker.getPosition().latitude;
            double pos2 = marker.getPosition().longitude;
            double plus = 0.05000;
            double minus = -0.05000;

            LatLng garden = new LatLng(pos1,pos2);
            LatLng plant1_pos = new LatLng(pos1+plus,pos2+plus);
            LatLng plant2_pos = new LatLng(pos1+minus,pos2+minus);
            LatLng plant3_pos = new LatLng(pos1+plus,pos2+minus);
            LatLng plant4_pos = new LatLng(pos1+minus,pos2+plus);
            LatLng plant5_pos = new LatLng(pos1+plus,pos2);
            LatLng plant6_pos = new LatLng(pos1+minus,pos2);
            plant1.setPosition(plant1_pos);
            plant2.setPosition(plant2_pos);
            plant3.setPosition(plant3_pos);
            plant4.setPosition(plant4_pos);
            plant5.setPosition(plant5_pos);
            plant6.setPosition(plant6_pos);
            marker.setTag(tag_name);

            if(clicked_name.equals("Supul's Garden")){
                plant1.setVisible(true);
                plant2.setVisible(true);
                //plant3.setVisible(true);
                //plant4.setVisible(true);
                //plant5.setVisible(true);
                //plant6.setVisible(true);

            }

            if(clicked_name.equals("Shamalka's Garden")){
                plant1.setVisible(true);
                plant2.setVisible(true);
                plant3.setVisible(true);
                //plant4.setVisible(true);
                //plant5.setVisible(true);
                //plant6.setVisible(true);

            }

            if(clicked_name.equals("Chashika's Garden")){
                //plant1.setVisible(true);
                plant2.setVisible(true);
                plant3.setVisible(true);
                plant4.setVisible(true);
                plant5.setVisible(true);
                //plant6.setVisible(true);

            }

            if(clicked_name.equals("Pasindu's Garden")){
                plant1.setVisible(true);
                //plant2.setVisible(true);
                //plant3.setVisible(true);
                //plant4.setVisible(true);
                plant5.setVisible(true);
                //plant6.setVisible(true);

            }

            if(clicked_name.equals("Lalanga's Garden")){
                plant1.setVisible(true);
                plant2.setVisible(true);
                plant3.setVisible(true);
                plant4.setVisible(true);
                plant5.setVisible(true);
                plant6.setVisible(true);

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(garden, 11));

        }

        return false;
    }

    public Marker CreateGarden(String name,LatLng position,Integer radius,Integer image){
        Marker NewMarker;
        NewMarker = mMap.addMarker(new MarkerOptions()
                .position(position)
                .snippet("Score :10")
                .icon(BitmapDescriptorFactory.fromResource(image))
                .title(name));
        NewMarker.setTag(0);

        Circle circle = mMap.addCircle(new CircleOptions()
                .center(position)
                .radius(radius)
                .strokeColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary))
                .fillColor(ContextCompat.getColor(getBaseContext(),R.color.colorGarden)));

        return NewMarker;

    }

    public Marker CreatePlant(String plant_name,double pos1,double pos2,Integer image){
        Marker NewMarker;
        LatLng plant_position = new LatLng(pos1,pos2);
        NewMarker = mMap.addMarker(new MarkerOptions().position(plant_position)
                .title(plant_name)
                .icon(BitmapDescriptorFactory.fromResource(image)));
        return NewMarker;
    }
}

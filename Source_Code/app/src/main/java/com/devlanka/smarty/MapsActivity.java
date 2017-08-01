package com.devlanka.smarty;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);



        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(8.356302, 80.484606))
                .radius(1000)
                .strokeColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary))
                .fillColor(ContextCompat.getColor(getBaseContext(),R.color.colorGarden)));

        // Add a marker in Sydney and move the camera
        LatLng plant1 = new LatLng(8.356302, 80.484606);
        LatLng plant2 = new LatLng(8.358402, 80.480406);
        LatLng plant3 = new LatLng(8.354312, 80.489616);

        mMap.addMarker(new MarkerOptions().position(plant1)
                .title("Supul's Graden")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.plant1_icon))
                .snippet("Plant1")
                .zIndex(1.0f));

        mMap.addMarker(new MarkerOptions().position(plant2)
                .title("Supul's Graden")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.plant2_icon))
                .snippet("Plant2")
                .zIndex(1.0f));

        mMap.addMarker(new MarkerOptions().position(plant3)
                .title("Supul's Graden")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.plant3_icon))
                .snippet("Plant3")
                .zIndex(1.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plant1, 14));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(supul));
    }
}

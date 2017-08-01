package com.devlanka.smarty;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
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
 * Created by Shamalka Navod on 2017-07-23.
 */
public class MapFragment extends android.support.v4.app.Fragment {
    private Marker plant1,plant2,plant3,plant4,plant5,plant6;
    private int plant1_img,plant2_img,plant3_img,plant4_img,plant5_img,plant6_img;
    private GoogleMap mMap;
    MapView mMapView;


    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_fragment, container, false);


        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap mMap) {
                //final GoogleMap mMap = mMap;
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                mMap.getUiSettings().setZoomGesturesEnabled(true);
                mMap.getUiSettings().setZoomControlsEnabled(true);


                plant1_img = R.drawable.plant1_icon;
                plant2_img = R.drawable.plant2_icon;
                plant3_img = R.drawable.plant3_icon;
                plant4_img = R.drawable.plant4_icon;
                plant5_img = R.drawable.plant5_icon;
                plant6_img = R.drawable.plant6_icon;

                plant1 = CreatePlant("Basil Spicy",18.358302, 80.486606,plant1_img,mMap);
                plant2 = CreatePlant("Watercress",18.354302, 80.480606,plant2_img,mMap);
                plant3 = CreatePlant("Tatsoi",18.350480, 80.485570,plant3_img,mMap);
                plant4 = CreatePlant("Summer Savory",18.350480, 80.485570,plant4_img,mMap);
                plant5 = CreatePlant("Kale Lacy",18.350480, 80.485570,plant5_img,mMap);
                plant6 = CreatePlant("Leaf Radish",18.350480, 80.485570,plant6_img,mMap);
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

                Marker supul = CreateGarden("My Garden",new LatLng(8.356302, 80.484606),10000,supul_img,mMap);
                Marker shamalka = CreateGarden("Shamalka's Garden",new LatLng(8.108242, 80.900188),15000,shamalka_img,mMap);
                Marker chashika = CreateGarden("Chashika's Garden",new LatLng(7.047637, 81.122146),24000,chashika_img,mMap);
                Marker pasindu = CreateGarden("Pasindu's Garden",new LatLng(6.343857, 80.495925),14000,pasindu_img,mMap);
                Marker lalanga = CreateGarden("Lalanga's Garden",new LatLng(7.117311, 80.103679),45000,lalanga_img,mMap);


                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(8.356302, 80.484606), 11));
                //mMap.setOnMarkerClickListener(this);

                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        // TODO Auto-generated method stub
//                        marker.showInfoWindow();
                        onMarkerClick1(marker,mMap);
                        return false;
                    }

                });
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
        });

        return rootView;
    }

    public boolean onMarkerClick1(final Marker marker,GoogleMap mMap) {

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

            if(clicked_name.equals("My Garden")){
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
                plant4.setVisible(true);
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
            // For zooming automatically to the location of the marker
            //CameraPosition cameraPosition = new CameraPosition.Builder().target(garden).zoom(11).build();
            //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        }

        return false;
    }




    public Marker CreateGarden(String name,LatLng position,Integer radius,Integer image,GoogleMap mMap){
        Marker NewMarker;
        NewMarker = mMap.addMarker(new MarkerOptions()
                .position(position)
                .snippet("Plants")
                .icon(BitmapDescriptorFactory.fromResource(image))
                .title(name));
        NewMarker.setTag(0);

        Circle circle = mMap.addCircle(new CircleOptions()
                .center(position)
                .radius(radius)
                .strokeColor(ContextCompat.getColor(getActivity(),R.color.colorPrimary))
                .fillColor(ContextCompat.getColor(getActivity(),R.color.colorGarden)));

        return NewMarker;

    }

    public Marker CreatePlant(String plant_name,double pos1,double pos2,Integer image,GoogleMap mMap){
        Marker NewMarker;
        LatLng plant_position = new LatLng(pos1,pos2);
        NewMarker = mMap.addMarker(new MarkerOptions().position(plant_position)
                .title(plant_name)
                .icon(BitmapDescriptorFactory.fromResource(image)));
        return NewMarker;
    }



    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
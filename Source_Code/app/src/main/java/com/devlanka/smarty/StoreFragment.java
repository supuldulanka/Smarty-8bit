package com.devlanka.smarty;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shamalka Navod on 2017-07-23.
 */

public class StoreFragment extends android.support.v4.app.Fragment {

    public static StoreFragment newInstance() {
        StoreFragment fragment = new StoreFragment();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.store_fragment, container, false);

        final TextView text = (TextView) v.findViewById(R.id.max_sun);
        final ImageView buy = (ImageView) v.findViewById(R.id.buy_img);

        Button button = (Button) v.findViewById(R.id.overflow);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_LONG).show();


            }
        });

        final ImageView thumb = (ImageView) v.findViewById(R.id.thumbnail);
        thumb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Intent myIntent = new Intent(getActivity(), BuyActivity.class);
                //StoreFragment.this.startActivity(myIntent);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
                // set title
                alertDialogBuilder.setTitle("       Swamp Thing");

                // set dialog message
                alertDialogBuilder
                        .setView(R.layout.buy_activity)
                        .setCancelable(false)
                        .setPositiveButton("Add to cart",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                dialog.cancel();
                                Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_LONG).show();

                            }

                        })
                        .setNegativeButton("Close",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

        //final ImageView image = (ImageView) v.findViewById(R.id.buy_img);


        CardView card = (CardView) v.findViewById(R.id.card_view);
        card.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Intent myIntent = new Intent(getActivity(), BuyActivity.class);
                //StoreFragment.this.startActivity(myIntent);

                //

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

                // set title
                alertDialogBuilder.setTitle("             Basil Spicy");
                // set dialog message
                alertDialogBuilder
                        .setView(R.layout.buy_activity)
                        .setCancelable(false)
                        .setPositiveButton("Add to cart",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_LONG).show();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Close",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                //text.setText("Max Sunlight: 10%");
                // show it
                alertDialog.show();



            }


        });



        return v;


    }




}

package com.axisrooms.channelmanager.com.axisrooms.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.axisrooms.channelmanager.R;
import com.axisrooms.channelmanager.com.axisrooms.constants.Attributes;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.future.ImageViewFuture;

/**
 * Created by bidhu on 4/8/16.
 */
public class Homefragment extends Fragment {

    Intent hotelDetails;

    public Homefragment(){
    }

    public Intent getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(Intent hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.home_layout, container, false);
        TextView hotelName=(TextView) view.findViewById(R.id.hotelName);
        TextView location=(TextView) view.findViewById(R.id.hotellocation);
        ImageView hotelImage=(ImageView)view.findViewById(R.id.hotelimage);

        hotelName.setText(hotelDetails.getStringExtra(Attributes.name));
        location.setText(hotelDetails.getStringExtra(Attributes.location));

        try {

            ImageViewFuture image = Ion.with(hotelImage).placeholder(R.drawable.hongkong)
                    .error(R.drawable.logo)
//                    .animateIn(fadeInAnimation)
                    .load(Attributes.imageURL);
        }catch (Exception ex)
        {
        }

        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
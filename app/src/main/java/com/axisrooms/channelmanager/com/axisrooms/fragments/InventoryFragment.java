package com.axisrooms.channelmanager.com.axisrooms.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.axisrooms.channelmanager.R;
import com.axisrooms.channelmanager.com.axisrooms.constants.Attributes;


/**
 * Created by bidhu on 4/8/16.
 */
public class InventoryFragment extends Fragment {
    private Intent hotelDetails;
    private Context context;


    public InventoryFragment() {
    }

    public Intent getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(Intent hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context= context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.inventory_fragment, container, false);
        TextView hotelName=(TextView) view.findViewById(R.id.hotelName);
        TextView location=(TextView) view.findViewById(R.id.hotellocation);
        hotelName.setText(hotelDetails.getStringExtra(Attributes.name));
        location.setText(hotelDetails.getStringExtra(Attributes.location));
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
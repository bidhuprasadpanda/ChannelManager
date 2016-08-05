package com.axisrooms.channelmanager.com.axisrooms.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axisrooms.channelmanager.R;


/**
 * Created by bidhu on 4/8/16.
 */
public class inventoryfragment extends Fragment {

    public inventoryfragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.home_layout, container, false);
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
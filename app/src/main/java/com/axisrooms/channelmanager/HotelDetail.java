package com.axisrooms.channelmanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.axisrooms.channelmanager.com.axisrooms.fragments.HomeFragment;
import com.axisrooms.channelmanager.com.axisrooms.fragments.InventoryFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnTabSelectedListener;

/**
 * Created by bidhu on 4/8/16.
 */
public class HotelDetail extends AppCompatActivity {

    private BottomBar bottomBar;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_details_activity);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        bottomBar = BottomBar.attach(this, savedInstanceState);
        Intent hotelDetails = getIntent();
        HomeFragment homeFragment =new HomeFragment();
        homeFragment.setHotelDetails(hotelDetails);
        homeFragment.setContext(this);
        InventoryFragment inventoryFragment =new InventoryFragment();
        inventoryFragment.setHotelDetails(hotelDetails);
        inventoryFragment.setContext(this);
        bottomBar.setFragmentItems(getSupportFragmentManager(), R.id.fragmentContainer,
            new BottomBarFragment(homeFragment, R.mipmap.ic_local_dining_white_24dp, "Home"),
            new BottomBarFragment(inventoryFragment, R.mipmap.ic_favorite_white_24dp, "Inventory"),
            new BottomBarFragment(inventoryFragment, R.mipmap.ic_favorite_white_24dp, "Price"),
            new BottomBarFragment(inventoryFragment, R.mipmap.ic_favorite_white_24dp, "Bookings")
        );


        bottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                switch (position) {
                    case 0:
                        // Item 1 Selected
                }
            }
        });

//        // Make a Badge for the first tab, with red background color and a value of "4".
        BottomBarBadge noofBookings = bottomBar.makeBadgeForTabAt(3, "#E91E63", 20);
//        BottomBarBadge newMessages = bottomBar.makeBadgeForTabAt(3, "#9B26AF" , 10);

        // Control the badge's visibility
        noofBookings.show();
        //unreadMessages.hide();

        // Change the displayed count for this badge.
        //unreadMessages.setCount(4);

        // Change the show / hide animation duration.
       noofBookings.setAnimationDuration(200);
//        newMessages.setAnimationDuration(600);

        // If you want the badge be shown always after unselecting the tab that contains it.
        noofBookings.setAutoShowAfterUnSelection(true);

    }
}

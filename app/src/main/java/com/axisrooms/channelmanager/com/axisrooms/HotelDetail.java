package com.axisrooms.channelmanager.com.axisrooms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.axisrooms.channelmanager.R;
import com.axisrooms.channelmanager.com.axisrooms.fragments.Homefragment;
import com.axisrooms.channelmanager.com.axisrooms.fragments.inventoryfragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnTabSelectedListener;

/**
 * Created by bidhu on 4/8/16.
 */
public class HotelDetail extends AppCompatActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_details);
        bottomBar = BottomBar.attach(this, savedInstanceState);
        Intent hotelDetails = getIntent();
        Homefragment homefragment=new Homefragment();
        homefragment.setHotelDetails(hotelDetails);

        bottomBar.setFragmentItems(getSupportFragmentManager(), R.id.fragmentContainer,
//                new BottomBarFragment(SampleFragment.newInstance("Content for recents."), R.drawable.ic_update_white_24dp, "Recents"),
//                new BottomBarFragment(SampleFragment.newInstance("Content for food."), R.drawable.ic_local_dining_white_24dp, "Food"),
//                new BottomBarFragment(SampleFragment.newInstance("Content for favorites."), R.drawable.ic_favorite_white_24dp, "Favorites"),
                new BottomBarFragment(homefragment, R.mipmap.ic_local_dining_white_24dp, "Location"),
                new BottomBarFragment(new inventoryfragment(), R.mipmap.ic_favorite_white_24dp, "Location")
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
//        BottomBarBadge unreadMessages = bottomBar.makeBadgeForTabAt(0, "#E91E63", 4);
//        BottomBarBadge newMessages = bottomBar.makeBadgeForTabAt(3, "#9B26AF" , 10);

        // Control the badge's visibility
//        unreadMessages.show();
        //unreadMessages.hide();

        // Change the displayed count for this badge.
        //unreadMessages.setCount(4);

        // Change the show / hide animation duration.
//        unreadMessages.setAnimationDuration(200);
//        newMessages.setAnimationDuration(600);

        // If you want the badge be shown always after unselecting the tab that contains it.
        //unreadMessages.setAutoShowAfterUnSelection(true);

    }
}

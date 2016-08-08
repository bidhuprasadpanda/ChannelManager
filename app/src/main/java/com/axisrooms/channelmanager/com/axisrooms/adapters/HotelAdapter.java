package com.axisrooms.channelmanager.com.axisrooms.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.axisrooms.channelmanager.HotelListActivity;
import com.axisrooms.channelmanager.R;
import com.axisrooms.channelmanager.HotelDetail;
import com.axisrooms.channelmanager.com.axisrooms.constants.Attributes;
import com.axisrooms.channelmanager.com.axisrooms.constants.ParameterConstants;
import com.axisrooms.channelmanager.com.axisrooms.jsonclass.HotelsListResponse;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.future.ImageViewFuture;

/**
 * Created by bidhu on 1/8/16.
 */
public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {

    private Context mContext;
    private HotelsListResponse hotelsListResponse;
    private HotelListActivity hotelListActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;
        public TextView searchField;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.hotelName);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public HotelAdapter(Context mContext, HotelsListResponse hotelsListResponse) {
        this.mContext = mContext;
        this.hotelsListResponse = hotelsListResponse;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final HotelsListResponse.HotelDetails hotelDetails = hotelsListResponse.getHotelList().get(position);
        holder.title.setText(hotelDetails.getName());
        holder.count.setText(hotelDetails.getLocation());

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "position "+selectedPosition, Snackbar.LENGTH_LONG).show();

                String hotelImage=hotelDetails.getImage();
                int hotelId=hotelDetails.getId();

                Intent hotelDetails=new Intent(mContext,HotelDetail.class);
                hotelDetails.putExtra(Attributes.name, holder.title.getText().toString());
                hotelDetails.putExtra(ParameterConstants.hotelId, hotelId);
                hotelDetails.putExtra(Attributes.location,  holder.count.getText().toString());
                hotelDetails.putExtra(Attributes.imageURL, hotelImage);
                mContext.startActivity(hotelDetails);
            }
        });

        // loading album cover using Glide library
     //  Glide.with(mContext).load(R.drawable.splash_background).into(holder.thumbnail);

        try {

            ImageViewFuture image = Ion.with(holder.thumbnail).placeholder(R.drawable.hongkong)
                    .error(R.drawable.logo)
//                    .animateIn(fadeInAnimation)
                    .load(hotelDetails.getImage());
        }catch (Exception ex)
        {
        }

    }

    @Override
    public int getItemCount() {
        return hotelsListResponse.getHotelList().size();
    }
}

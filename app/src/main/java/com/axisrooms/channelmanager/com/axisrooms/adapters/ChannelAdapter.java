package com.axisrooms.channelmanager.com.axisrooms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.axisrooms.channelmanager.R;
import com.axisrooms.channelmanager.com.axisrooms.jsonclass.ChannelListResponse;

/**
 * Created by bidhu on 5/8/16.
 */
public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder> {

    private Context mContext;
    private ChannelListResponse channelListResponse;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView hotelName;

        public MyViewHolder(View view) {
            super(view);
            hotelName = (TextView) view.findViewById(R.id.hotelName);
        }
    }


    public ChannelAdapter(Context mContext, ChannelListResponse channelListResponse) {
        this.mContext = mContext;
        this.channelListResponse = channelListResponse;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channels_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final String channelName = channelListResponse.getChannelsList().get(position);
        holder.hotelName.setText(channelName);
    }

    @Override
    public int getItemCount() {
        return channelListResponse.getChannelsList().size();
    }
}

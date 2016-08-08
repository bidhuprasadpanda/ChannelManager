package com.axisrooms.channelmanager.com.axisrooms.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.axisrooms.channelmanager.R;
import com.axisrooms.channelmanager.com.axisrooms.adapters.ChannelAdapter;
import com.axisrooms.channelmanager.com.axisrooms.constants.Attributes;
import com.axisrooms.channelmanager.com.axisrooms.constants.EndPoints;
import com.axisrooms.channelmanager.com.axisrooms.constants.ParameterConstants;
import com.axisrooms.channelmanager.com.axisrooms.jsonclass.ChannelListResponse;
import com.axisrooms.channelmanager.com.axisrooms.request.OkHttpHandler;
import com.axisrooms.channelmanager.com.axisrooms.userDetails.AgentData;
import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.future.ImageViewFuture;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by bidhu on 4/8/16.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChannelAdapter channelAdapter;
    private ChannelListResponse channelListResponse;

    private Intent hotelDetails;
    private Context context;

    public HomeFragment(){
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
        View view =inflater.inflate(R.layout.home_fragment, container, false);

        ImageView hotelImage=(ImageView)view.findViewById(R.id.hotelimage);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_channel_view);
        TextView hotelName=(TextView) view.findViewById(R.id.hotelName);
        TextView location=(TextView) view.findViewById(R.id.hotellocation);
        hotelName.setText(hotelDetails.getStringExtra(Attributes.name));
        location.setText(hotelDetails.getStringExtra(Attributes.location));

        ImageViewFuture image = Ion.with(hotelImage).placeholder(R.drawable.hongkong)
                    .error(R.drawable.logo)
//                    .animateIn(fadeInAnimation)
                    .load(hotelDetails.getStringExtra(Attributes.imageURL));

        HashMap<String,String> rqParams=new HashMap<>();
        rqParams.put(ParameterConstants.userType, AgentData.getUserTypeId());
        rqParams.put(ParameterConstants.session_id,AgentData.getSessionId());
        rqParams.put(ParameterConstants.supplierId,String.valueOf(AgentData.getSupplierId()));
        rqParams.put(ParameterConstants.hotelId,hotelDetails.getIntExtra(ParameterConstants.hotelId,0)+"");

        OkHttpHandler handler=new OkHttpHandler(EndPoints.hexchennelslist,rqParams,  OkHttpHandler.MethodType.POST);
        String result=null;

        try{
            result=handler.execute().get();
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException i){
            i.printStackTrace();
        }
        if(result!=null)
        {
            try{
                channelListResponse=new Gson().fromJson(result, ChannelListResponse.class);

            }catch (Exception e)
            {
                Log.v("Response","Channels list parse Error "+e.getMessage());
            }

        }
        channelAdapter = new ChannelAdapter(context, channelListResponse);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new HomeFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(channelAdapter);
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
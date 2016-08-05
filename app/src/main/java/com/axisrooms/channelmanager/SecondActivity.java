package com.axisrooms.channelmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.axisrooms.channelmanager.com.axisrooms.constants.EndPoints;
import com.axisrooms.channelmanager.com.axisrooms.jsonclass.HotelsListResponse;
import com.axisrooms.channelmanager.com.axisrooms.request.OkHttpHandler;
import com.axisrooms.channelmanager.com.axisrooms.userDetails.AgentData;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

/**
 * Created by bidhu on 2/8/16.
 */
public class SecondActivity extends AppCompatActivity {

    public HotelsListResponse hotelsListResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);
        TextView name = (TextView) findViewById(R.id.userName);
        name.setText(AgentData.getNAME());

        String jsonData="{\n" +
                "   \"supplier_id\":1101,\n" +
                "   \"hotel_id\":204,\n" +
                "   \"session_id\":\"9913F5DAC126533DCB6748D76CA13E43\"\n" +
                "}";

        OkHttpHandler handler = new OkHttpHandler(null, EndPoints.hotelList, OkHttpHandler.MethodType.POST,jsonData);
        String result = null;
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
                hotelsListResponse=new Gson().fromJson(result, HotelsListResponse.class);


            }catch (Exception e)
            {
               // Snackbar.make(v, "Invalid email ID or password", Snackbar.LENGTH_LONG).show();
            }

        }
    }
}

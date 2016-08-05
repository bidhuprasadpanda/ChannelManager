package com.axisrooms.channelmanager.com.axisrooms.request;

import android.os.AsyncTask;

import com.axisrooms.channelmanager.com.axisrooms.constants.HttpLinks;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bidhu on 29/7/16.
 */
public class OkHttpHandler extends AsyncTask<String, Void, String> {

    public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    HashMap<String,String> rqParams;
    final String URL= HttpLinks.SERVER_IP_PROD;
    String endPoint;
    MethodType mtype;
    String json;
    public OkHttpHandler(HashMap<String,String> rqParams,String endPoint, MethodType mtype,String json) {
        this.rqParams = rqParams;
        this.endPoint=endPoint;
        this.mtype=mtype;
        this.json=json;
    }

    @Override
    protected String doInBackground(String... params) {

        if(mtype==MethodType.GET)
        {
            FormEncodingBuilder formEncodingBuilder=new  FormEncodingBuilder();
            for(Map.Entry<String,String> rqParam:rqParams.entrySet())
            {
                formEncodingBuilder.add(rqParam.getKey(),rqParam.getValue());
            }
            RequestBody body=formEncodingBuilder.build();

            Request request=new Request.Builder().
                    url(URL+endPoint).post(body).build();
            try {
                Response response = client.newCall(request).execute();
                if (!response.isSuccessful())
                    throw new IOException("Unexpected Exception "+response.toString());
                return response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else if(mtype==MethodType.POST)
        {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(URL+endPoint)
                    .post(body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception ex)
            {
                ex.printStackTrace();
                return  null;
            }
        }
        return  null;
    }




    public enum MethodType{
        GET,POST
    }
}

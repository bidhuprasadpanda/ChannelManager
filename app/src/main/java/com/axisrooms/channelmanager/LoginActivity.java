package com.axisrooms.channelmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.axisrooms.channelmanager.com.axisrooms.constants.EndPoints;
import com.axisrooms.channelmanager.com.axisrooms.constants.ParameterConstants;
import com.axisrooms.channelmanager.com.axisrooms.jsonclass.LoginResponse;
import com.axisrooms.channelmanager.com.axisrooms.request.OkHttpHandler;
import com.axisrooms.channelmanager.com.axisrooms.userDetails.AgentData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    LoginResponse loginResponse=null;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Session Manager
        session = new SessionManager(getApplicationContext());

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);
        /*
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();*/

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> rqParams=new HashMap<>();
                rqParams.put(ParameterConstants.emailId,username.getText().toString());
                rqParams.put(ParameterConstants.password,password.getText().toString());
                rqParams.put(ParameterConstants.userType,"1");

                OkHttpHandler handler=new OkHttpHandler(rqParams, EndPoints.Login, OkHttpHandler.MethodType.GET,"");
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
                        loginResponse=new Gson().fromJson(result, LoginResponse.class);

                        if(loginResponse.isStatus())
                        {

                            session.createLoginSession(AgentData.getNAME(),username.getText().toString() );
                            AgentData.saveAgentLoginData(getApplicationContext(),loginResponse);

                            Intent secondActivity=new Intent(getApplicationContext(),HotelListActivity.class);
                            startActivity(secondActivity);
                            //Intent hotelListActivity=new Intent(getApplicationContext(),HotelListActivity.class);
                            //Log.v("",AgentData.getSupplierId()+"");
                            //startActivity(hotelListActivity);
                            //Log.v("Response",loginResponse.getSupplierId()+"--"+loginResponse.getName()+ "  the response");
                        }else
                        {
                            Snackbar.make(v, "Invalid email ID or password", Snackbar.LENGTH_LONG).show();
                        }

                    }catch (Exception e)
                    {
                        Snackbar.make(v, "Invalid email ID or password", Snackbar.LENGTH_LONG).show();
                    }

                }
            }

        });

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


}

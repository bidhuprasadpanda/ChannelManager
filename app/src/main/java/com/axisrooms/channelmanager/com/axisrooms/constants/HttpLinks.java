package com.axisrooms.channelmanager.com.axisrooms.constants;

/**
 * Created by bidhu on 29/7/16.
 */
public class HttpLinks {

    public static String SERVER_IP_PROD = "http://www.axisrooms.com/hexapi/";

    static {
        if(AxisroomsProperties.isDev())
        {
            SERVER_IP_PROD=    "http://52.76.84.22:8080/hexapi/";

            if(AxisroomsProperties.isLocal())
            {
                SERVER_IP_PROD=    "http://192.168.1.193:8080/hexapi/";
            }
        }
    }

}

package com.axisrooms.channelmanager.com.axisrooms.constants;

/**
 * Created by bidhu on 29/7/16.
 */
public class AxisroomsProperties {
    private static boolean IS_DEV = true;
    private static boolean IS_LOCAL = true;

    public static boolean isLocal(){
        return IS_LOCAL;
    }
    public static boolean isDev() {
        return IS_DEV;
    }
}

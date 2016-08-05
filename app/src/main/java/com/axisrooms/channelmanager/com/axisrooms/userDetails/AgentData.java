package com.axisrooms.channelmanager.com.axisrooms.userDetails;

import android.content.Context;

import com.axisrooms.channelmanager.com.axisrooms.jsonclass.LoginResponse;

/**
 * Created by bidhu on 1/8/16.
 */
public class AgentData {

    private static String SESSION_ID = "";
    private static long SUPPLIER_ID = 0L;
    private static String NAME = "";
    private static String userTypeId="";

    private static String selectedHotelImage="";
    private static String selectedHotelName="";
    private static String selectedHotelAddrress="";

    public static void saveAgentLoginData(Context context,
                                          LoginResponse lro) {
        SUPPLIER_ID = lro.getSupplierId();
        NAME = lro.getName();
        SESSION_ID = lro.getSESSIONID();
        userTypeId=lro.getUserType();
    }

    public static String getSelectedHotelImage() {
        return selectedHotelImage;
    }

    public static void setSelectedHotelImage(String selectedHotelImage) {
        AgentData.selectedHotelImage = selectedHotelImage;
    }

    public static String getSelectedHotelName() {
        return selectedHotelName;
    }

    public static void setSelectedHotelName(String selectedHotelName) {
        AgentData.selectedHotelName = selectedHotelName;
    }

    public static String getSelectedHotelAddrress() {
        return selectedHotelAddrress;
    }

    public static void setSelectedHotelAddrress(String selectedHotelAddrress) {
        AgentData.selectedHotelAddrress = selectedHotelAddrress;
    }

    public static String getSessionId() {
        return SESSION_ID;
    }

    public static void setSessionId(String sessionId) {
        SESSION_ID = sessionId;
    }

    public static long getSupplierId() {
        return SUPPLIER_ID;
    }

    public static void setSupplierId(long supplierId) {
        SUPPLIER_ID = supplierId;
    }

    public static String getNAME() {
        return NAME;
    }

    public static void setNAME(String NAME) {
        AgentData.NAME = NAME;
    }

    public static String getUserTypeId() {
        return userTypeId;
    }

    public static void setUserTypeId(String userTypeId) {
        AgentData.userTypeId = userTypeId;
    }

    public static void clear() {

    }
}

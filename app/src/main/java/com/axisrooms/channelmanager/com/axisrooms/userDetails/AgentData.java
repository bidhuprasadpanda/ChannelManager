package com.axisrooms.channelmanager.com.axisrooms.userDetails;


import com.axisrooms.channelmanager.com.axisrooms.jsonclass.LoginResponse;

/**
 * Created by bidhu on 1/8/16.
 */
public class AgentData {

    private static String SESSION_ID = "";
    private static long SUPPLIER_ID = 0L;
    private static String NAME = "";
    private static String userTypeId="";
    private static  String SUPPLIER_EMAIL ="";

    private static String selectedHotelImage="";
    private static String selectedHotelName="";
    private static String selectedHotelAddrress="";

    private static  String hotelLocaction="";
    private static  long hotelId=0;


    public static void saveAgentLoginData(LoginResponse lro) {
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

    public static String getHotelLocaction() {
        return hotelLocaction;
    }

    public static void setHotelLocaction(String hotelLocaction) {
        AgentData.hotelLocaction = hotelLocaction;
    }

    public static long getHotelId() {
        return hotelId;
    }

    public static void setHotelId(long hotelId) {
        AgentData.hotelId = hotelId;
    }

    public static String getSupplierEmail() {
        return SUPPLIER_EMAIL;
    }

    public static void setSupplierEmail(String supplierEmail) {
        AgentData.SUPPLIER_EMAIL = supplierEmail;
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

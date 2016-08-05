package com.axisrooms.channelmanager.com.axisrooms.jsonclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("supplierId")
    @Expose
    private int supplierId;
    @SerializedName("SESSION_ID")
    @Expose
    private String sESSIONID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("userType")
    @Expose
    private String userType;

    /**
     *
     * @return
     * The status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The supplierId
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     *
     * @param supplierId
     * The supplierId
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     *
     * @return
     * The sESSIONID
     */
    public String getSESSIONID() {
        return sESSIONID;
    }

    /**
     *
     * @param sESSIONID
     * The SESSION_ID
     */
    public void setSESSIONID(String sESSIONID) {
        this.sESSIONID = sESSIONID;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     * The userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

}

package com.axisrooms.channelmanager.com.axisrooms.jsonclass;

/**
 * Created by bidhu on 1/8/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class HotelsListResponse {

    @SerializedName("hotelList")
    @Expose
    private List<HotelDetails> hotelList = new ArrayList<>();

    /**
     *
     * @return
     * The hotelList
     */
    public List<HotelDetails> getHotelList() {
        return hotelList;
    }

    /**
     *
     * @param hotelList
     * The hotelList
     */
    public void setHotelList(List<HotelDetails> hotelList) {
        this.hotelList = hotelList;
    }
    public static class HotelDetails {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("cm_product_id")
        @Expose
        private int cmProductId;

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
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The id
         */
        public int getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The location
         */
        public String getLocation() {
            return location;
        }

        /**
         *
         * @param location
         * The location
         */
        public void setLocation(String location) {
            this.location = location;
        }

        /**
         *
         * @return
         * The address
         */
        public String getAddress() {
            return address;
        }

        /**
         *
         * @param address
         * The address
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         *
         * @return
         * The cmProductId
         */
        public int getCmProductId() {
            return cmProductId;
        }

        /**
         *
         * @param cmProductId
         * The cm_product_id
         */
        public void setCmProductId(int cmProductId) {
            this.cmProductId = cmProductId;
        }

    }
}


package com.axisrooms.channelmanager.com.axisrooms.jsonclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bidhu on 5/8/16.
 */
public class ChannelListResponse {
    @SerializedName("channelsList")
    @Expose
    private List<String> channelsList = new ArrayList<String>();

    /**
     *
     * @return
     * The channelsList
     */
    public List<String> getChannelsList() {
        return channelsList;
    }

    /**
     *
     * @param channelsList
     * The channelsList
     */
    public void setChannelsList(List<String> channelsList) {
        this.channelsList = channelsList;
    }
}

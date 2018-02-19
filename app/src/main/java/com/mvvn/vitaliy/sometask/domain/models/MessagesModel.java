package com.mvvn.vitaliy.sometask.domain.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rud on 2/17/18.
 */

public class MessagesModel {

    @SerializedName("Body")
    private String body;

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
         this.body = body;
    }

}

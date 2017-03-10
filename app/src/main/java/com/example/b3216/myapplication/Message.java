package com.example.b3216.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by b3216 on 2017-03-04.
 */

public class Message {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("message")
    @Expose
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
//public class Message implements Serializable {
//
//
//    @SerializedName("id")
//    @Expose
//    private String id;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("response")
//    @Expose
//    private String reponse;
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {this.message = message;}
//
//    public String getId() { return id;}
//
//    public void setId(String id) {this.id = id;}
//}

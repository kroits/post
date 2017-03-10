package com.example.b3216.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


/**
 * Created by b3216 on 2017-03-04.
 */

public interface MessageService {
    @GET("api/message/{message_id}")
    Call<Message> getMessage(@Path("message_id") String id);


    @FormUrlEncoded
    @POST("api/message")

    Call<Message> postMessage(
            @Field("id") String id,
            @Field("message") String message
    );
    @POST("api/message")
    @FormUrlEncoded
    Call<Message> postMessage(@Body Message post);

    @PUT("api/message")
    Call<Message> putMessage(
            @Field("id") String id,
            @Field("message") String message
    );

    @DELETE("api/message/{message_id}")
    Call<Void> deleteRecord(@Path("message_id") String id);
}

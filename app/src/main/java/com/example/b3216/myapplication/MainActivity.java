package com.example.b3216.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    Message test = new Message();

    TextView textview;
    String temp = "{\"id\"" + ":"+"\""+"2" + "\"" + "," + "\"message\"" + ":" + "\" change" + "\"" +"}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview = (TextView)findViewById(R.id.textview);


        test.setId("1");
        test.setMessage("second test");

        init();
        post("1","testset");

//        prin = get("1");
//        String prin1 = prin.getMessage();
//        textview.setText(prin.getMessage());
//        textview.setText(prin.getMessage());
//        textview.setText("change");
        //send();
    }

    DefaultRestClient<MessageService> ddDefaultRestClient;
    MessageService mMessageService;

    private void init() {
        ddDefaultRestClient = new DefaultRestClient<>();
        mMessageService = ddDefaultRestClient.getClient(MessageService.class);

        Log.d("jyp","init");
    }

    /*private void send(){
        Log.d("jyp","send");

        Call<Message> call = mMessageService.getMessage("1");
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("fe", "success");
                    Message test = response.body();
                    Log.d("fe",test.getMessage());
                } else {
                    Log.d("fdfd", "fail");
                    Log.d("fd", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("fe", "fail2");
                t.printStackTrace();
            }
        });
    }

*/
//    private Message get(String id){
//        Log.d("fefe","get");
//        Call<Message> call = mMessageService.getMessage(id);
//        call.enqueue(new Callback<Message>() {
//            @Override
//            public void onResponse(Call<Message> call, Response<Message> response) {
//                if (response.isSuccessful()) {
//                    Log.d("fe", "success");
//                    test = response.body();
//                    Log.d("fe",test.getMessage());
//                } else {
//                    Log.d("fdfd", "fail");
//                    Log.d("fd", response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Message>call, Throwable t) {
//                Log.d("fe","fail2");
//                t.printStackTrace();
//            }
//        });
//        return test;
//    }

    private void post(String id, String message){
        Log.d("ss","post");
        mMessageService.postMessage(id, message).enqueue(new Callback<Message>() {

            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("ss", "success");
                    Log.d("ss",response.body().toString());
//                    test = response.body();
//                    Log.d("ss", test.getMessage());
                } else{
                    Log.d("ss", "fail");
                    Log.d("ss", response.errorBody().toString());
                    Log.d("Login_call", response.code() + "");

                }
            }

            @Override
            public void onFailure(Call<Message>call, Throwable t){
                Log.d("ss","fail2");
                t.printStackTrace();
            }
        });

    }

}

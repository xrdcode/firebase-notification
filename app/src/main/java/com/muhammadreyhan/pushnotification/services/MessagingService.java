package com.muhammadreyhan.pushnotification.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.muhammadreyhan.pushnotification.utility.Constant;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muhammad.reyhan on 24/12/2017.
 */

public class MessagingService extends FirebaseMessagingService {

    private static String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From : " + remoteMessage.getFrom());
        Log.d(TAG, "Notification : " + remoteMessage.getNotification().getBody());
    }

    public static void SendNotification(String body, String title, String topic , Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        try {
            JSONObject jObj = new JSONObject();
            JSONObject data = new JSONObject();
            data.put("body", body);
            data.put("title", title);
            jObj.put("notification", data);
            jObj.put("condition", "'"+topic+"' in topics");
            System.out.println(jObj.toString());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Constant.FCM_URL, jObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response : ", response.toString());
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.d("Error : ", error.getMessage());
                    }
                }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", Constant.DEFAULT_CONTENT_TYPE);
                    headers.put("Authorization", Constant.SERVER_KEYS);
                    return headers;
                }
            };
            requestQueue.add(jsonObjectRequest);
        } catch (Exception ex) {

        }
    }
}

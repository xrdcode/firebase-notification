package com.muhammadreyhan.pushnotification.services;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.muhammadreyhan.pushnotification.utility.Constant;

/**
 * Created by muhammad.reyhan on 24/12/2017.
 */

public class FirebaseIDService extends FirebaseInstanceIdService {
    private static String TAG = "Instance : ";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferences.edit().putString(Constant.FIREBASE_TOKEN, refreshedToken).apply();
    }
}

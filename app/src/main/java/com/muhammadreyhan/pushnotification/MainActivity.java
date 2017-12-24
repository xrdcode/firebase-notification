package com.muhammadreyhan.pushnotification;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;
import com.muhammadreyhan.pushnotification.services.MessagingService;
import com.muhammadreyhan.pushnotification.utility.Constant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText title = (EditText) findViewById(R.id.title);
        final EditText isi = (EditText) findViewById(R.id.isi);

        FirebaseMessaging.getInstance().subscribeToTopic("AppsNotifications");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessagingService.SendNotification(isi.getText().toString(), title.getText().toString(), Constant.APPS_DEFAULT_TOPIC, getApplicationContext());
            }
        });
    }

}

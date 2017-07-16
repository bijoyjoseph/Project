package com.finance.Network;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.finance.ChatActivity;
import com.finance.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by Avinash on 17-02-2016.
 */
public class ChatService extends Service implements ChildEventListener, ValueEventListener {
    private final String FIREBASE_URL = "https://android-chat.firebaseio-demo.com";
    private Firebase mFirebaseRef;

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        mFirebaseRef = new Firebase(FIREBASE_URL).child("chat");
        mFirebaseRef.addValueEventListener(this);
//        mFirebaseRef.addChildEventListener(this);
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Log.e("CC", "***************************Added*******************************");
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        Log.e("CC", "***************************Change*******************************");
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.e("CC", "***************************Change******************************* " + dataSnapshot.getChildrenCount());

        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

        int icon = R.drawable.firebase_logo;
        CharSequence tickerText = "Hello"; // ticker-text
        long when = System.currentTimeMillis();
        Context context = getApplicationContext();
        CharSequence contentTitle = "Hello";
        CharSequence contentText = "Hello";
        Intent notificationIntent = new Intent(this, ChatActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Notification notification = new Notification(icon, tickerText, when);
//        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

// and this
        final int HELLO_ID = 1;
        mNotificationManager.notify(HELLO_ID, notification);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }

    @Override
    public void onDestroy() {
        Log.e("CC", "  destroyed  ");
        super.onDestroy();
    }
}

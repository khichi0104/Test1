package com.kuk.test1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.content.Intent;
import java.util.Map;

/**
 * Created by KUK on 15/3/2560.
 */

public class NotificationServices extends FirebaseMessagingService {
    private static final String TAG  = "kuknoti";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        /*super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            Map<String,String> data = remoteMessage.getData();

            String pId = data.get("promotion_id");
           String pTitle = data.get("promotion_title");

            Log.d(TAG, "id = "+ pId );
            Log.d(TAG, "title  = "+ pTitle );
        }
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }*/

        sendNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"));

    }



    private void sendNotification(String messageTitle,String messageBody) {

        Intent intent = new Intent(this, Main2Activity.class  );
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 /* request code */, intent,PendingIntent.FLAG_UPDATE_CURRENT);

        long[] pattern = {500,500,500,500,500};

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon( R.mipmap.ic_launcher )
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setVibrate(pattern)
                .setLights(Color.BLUE,1,1)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }


}

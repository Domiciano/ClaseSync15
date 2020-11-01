package co.domi.clase10.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import co.domi.clase10.R;

public class NotificationUtil {

    private static final String CHANNEL_ID= "messages";
    private static final String CHANNEL_NAME= "Messages";
    private static final int CHANNEL_IMPORTANCE= NotificationManager.IMPORTANCE_HIGH;

    private static int idCounter = 0;

    public static void createNotification(Context context, String title, String msg, Intent intent){

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, CHANNEL_IMPORTANCE);
            manager.createNotificationChannel(channel);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(context, idCounter, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(msg)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.notificationicon)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = builder.build();
        manager.notify(idCounter, notification);
        idCounter++;
    }

}

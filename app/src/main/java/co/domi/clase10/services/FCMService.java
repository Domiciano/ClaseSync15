package co.domi.clase10.services;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import org.json.JSONObject;

import androidx.annotation.NonNull;
import co.domi.clase10.model.FCMMessage;
import co.domi.clase10.util.NotificationUtil;

//Firebase cloud messaging
public class FCMService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(">>>", remoteMessage.getData().toString());

        JSONObject object = new JSONObject(remoteMessage.getData());
        String json = object.toString();
        Log.e(">>>", json);

        Gson gson = new Gson();
        FCMMessage message = gson.fromJson(json, FCMMessage.class);

        NotificationUtil.createNotification(this, "Nuevo mensaje", message.getMessage());

    }
}

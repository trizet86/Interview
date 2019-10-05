package ru.geekbrains.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.Log;

public class MainService extends Service {

    private static final String TAG = "MainService";
    private ServiceBinder serviceBinder;
    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        if (serviceBinder == null){
            serviceBinder = new ServiceBinder();
        }
        return serviceBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        return false;
    }

    // вывод уведомления в строке состояния
    public void showNotification(String text, @DrawableRes int icon, int notifyId) {
        Notification notification = new Notification.Builder(getApplicationContext())
                //.setContentTitle("Progress")
                .setContentText(text)
                //.setTicker("Notification!")
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(icon)
                .build();

        notificationManager.notify(notifyId, notification);
    }

    public class ServiceBinder extends android.os.Binder {
        public MainService getService(){
            return MainService.this;
        }
    }
}

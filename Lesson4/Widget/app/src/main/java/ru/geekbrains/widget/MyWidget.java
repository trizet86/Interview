package ru.geekbrains.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.util.HashMap;
import java.util.function.BiFunction;

public class MyWidget extends AppWidgetProvider {
    private final static String ACTION_BUTTON_CLICK = "ru.geekbrains.widget.button_click";
    private static HashMap<Integer, Integer> countMap = new HashMap<>();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId);
        }
    }

    static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        RemoteViews widgetView = new RemoteViews(context.getPackageName(), R.layout.my_widget);

        // Здесь обновим текст, будем показывать номер виджета
        widgetView.setTextViewText(R.id.appwidget_text, String.format("%s - %d", widgetText, appWidgetId));

        if (!countMap.containsKey(appWidgetId)) {
            countMap.put(appWidgetId, 0);
        }

        Integer value = countMap.get(appWidgetId);
        if (value != null) {
            widgetView.setTextViewText(R.id.button, String.valueOf(value));
        }

        // Счетчик нажатий
        Intent countIntent = new Intent(context, MyWidget.class);
        countIntent.setAction(ACTION_BUTTON_CLICK);
        countIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, appWidgetId, countIntent, 0);
        widgetView.setOnClickPendingIntent(R.id.button, pIntent);

        appWidgetManager.updateAppWidget(appWidgetId, widgetView);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (intent.getAction().equalsIgnoreCase(ACTION_BUTTON_CLICK)) {
            // извлекаем ID экземпляра
            Bundle extras = intent.getExtras();
            if (extras != null) {
                int widgetId = extras.getInt(
                        AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID
                );

                if (widgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                    Integer value = countMap.get(widgetId);
                    if (value!= null) {
                        value++;
                        countMap.put(widgetId, value);

                        updateWidget(context, AppWidgetManager.getInstance(context), widgetId);
                    }
                }
            }
        }
    }
}


package ru.geekbrains.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean serviceBound = false;
    private MainService mainService;
    private int notifyId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectService();

        Button buttonStartService = findViewById(R.id.buttonStartService);
        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serviceBound) {
                    mainService.showNotification("Message " + notifyId, R.drawable.ic_announcement_black_24dp, notifyId++);
                }
            }
        });
    }

    private void connectService() {
        Intent intent = new Intent(MainActivity.this, MainService.class);
        ServiceConnection mainServiceConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName cName, IBinder service) {
                MainService.ServiceBinder binder = (MainService.ServiceBinder) service;
                mainService = binder.getService();
                serviceBound = true;
            }

            public void onServiceDisconnected(ComponentName cName) {
                serviceBound = false;
            }
        };
        bindService(intent, mainServiceConnection, BIND_AUTO_CREATE);
    }
}

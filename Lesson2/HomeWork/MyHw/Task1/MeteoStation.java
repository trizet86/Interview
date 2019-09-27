package com.company.Task1;

public class MeteoStation {
    public static void main(String[] args) {
        MeteoStore meteoDb = new MeteoStore();

        MeteoSensor ms200_1 = new MS200(1);
        meteoDb.save(ms200_1);

        ST500Info st500Info = new ST500Info();
        meteoDb.save(new MeteoSensorAdapter(st500Info.getData()));
        // Здесь надо вызвать метод getData у класса ST500Info. Полученные данные отправить в метод save объекта meteoDb
    }
}
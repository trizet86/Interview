package com.company.Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MeteoSensorAdapter implements MeteoSensor {

    private SensorTemperature sensor;

    public MeteoSensorAdapter(SensorTemperature sensor) {
        this.sensor = sensor;
    }

    @Override
    public int getId() {
        return sensor.identifier();
    }

    @Override
    public Float getTemperature() {
        return (float) sensor.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        LocalDate date = LocalDate.ofYearDay(sensor.year(), sensor.day());
        LocalTime time = LocalTime.ofSecondOfDay(sensor.second());
        return LocalDateTime.of(date, time);
    }
}

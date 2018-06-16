package sample;

import javafx.beans.property.SimpleStringProperty;

public class Measurement {
    public SimpleStringProperty name, startTime, stopTime, resultTime;

    public Measurement(String name, String startTime, String stopTime, String resultTime) {
        this.name = new SimpleStringProperty(name);
        this.startTime = new SimpleStringProperty(startTime);
        this.stopTime = new SimpleStringProperty (stopTime);
        this.resultTime = new SimpleStringProperty (resultTime);
    }
}

package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Objects;

public class Alarm {

    private final IntegerProperty hour;
    private final IntegerProperty minute;
    private final BooleanProperty isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alarm)) return false;
        Alarm alarm = (Alarm) o;
        return Objects.equals(getHour(), alarm.getHour()) &&
                Objects.equals(getMinute(), alarm.getMinute()) &&
                Objects.equals(getIsActive(), alarm.getIsActive());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getHour(), getMinute(), getIsActive());
    }


    public Alarm(int hour, int minute, boolean isActive) throws IllegalTimeValueException{

        if(( (hour < 0 || hour > 23) || (minute < 0 || minute > 59) ) ){

            throw new IllegalTimeValueException ("Illegal time value");
        }
        else {
            this.hour = new SimpleIntegerProperty(hour);
            this.minute = new SimpleIntegerProperty(minute);
            this.isActive = new SimpleBooleanProperty(isActive);
        }
    }

    public Alarm( Alarm al){
        this.hour = new SimpleIntegerProperty(al.getHour());
        this.minute = new SimpleIntegerProperty(al.getMinute());
        this.isActive = new SimpleBooleanProperty(al.getIsActive());
    }


    public int getHour() {
        return hour.get();
    }

    public void setHour(int hour) throws IllegalTimeValueException{
        if (hour < 0 || hour > 23 ) {
            throw new IllegalTimeValueException ("Illegal hour value");
        }
        else {
            this.hour.set(hour);
        }
    }

    public IntegerProperty hourProperty() {
        return hour;
    }

    public int getMinute() {
        return minute.get();
    }

    public void setMinute(int minute) throws IllegalTimeValueException{

        if(minute < 0 || minute > 59){
            throw new IllegalTimeValueException("Illegal minute value");
        }
        else {
            this.minute.set(minute);
        }
    }

    public IntegerProperty minuteProperty() {
        return minute;
    }

    public boolean getIsActive() {
        return isActive.get();
    }

    public void setIsActive (boolean isActive) {
        this.isActive.set(isActive);
    }

    public BooleanProperty isActiveProperty() {
        return isActive;
    }
}

package com.connectorio.bmshub.schedule.type;

import java.time.LocalTime;
import org.eclipse.smarthome.core.types.PrimitiveType;

public class TimeType implements PrimitiveType {

    private final LocalTime time;

    public TimeType(int hour, int minute) {
        this(hour, minute, 0);
    }

    public TimeType(int hour, int minute, int second) {
        this(hour, minute, second, 0);
    }

    public TimeType(int hour, int minute, int second, int nano) {
        this.time = LocalTime.of(hour, minute, second, nano);
    }

    public String format(String pattern) {
        return toFullString();
    }

    public String toFullString() {
        return "T" + time;
    }

    public String toString() {
        return toFullString();
    }
}

package com.connectorio.bmshub.schedule.type;

import org.eclipse.smarthome.core.types.*;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleType extends AbstractDecomposableType implements ComplexType, Command, State {

    private final List<ListType<PairType<TimeType, PrimitiveType>>> schedule;

    public ScheduleType() {
        this(new ArrayList<ListType<PairType<TimeType, PrimitiveType>>>());
    }

    public ScheduleType(List<ListType<PairType<TimeType, PrimitiveType>>> schedule) {
        this.schedule = schedule;
    }

    public Map<String, Type> getTypeMap() {
        Map<String, Type> valueMap = new LinkedHashMap<>();

        int index = 0;
        for (ListType value : schedule) {
            valueMap.put(Integer.valueOf(index++).toString(), value);
        }

        return valueMap;
    }

    public String format(String s) {
        return s;
    }

    public String toFullString() {
        return schedule.stream()
            .map(ListType::toFullString)
            .collect(Collectors.joining(";"));
    }

    public String toString() {
        return toFullString();
    }
}

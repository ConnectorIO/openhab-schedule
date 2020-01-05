package com.connectorio.bmshub.schedule.type;

import org.eclipse.smarthome.core.types.ComplexType;
import org.eclipse.smarthome.core.types.PrimitiveType;
import org.eclipse.smarthome.core.types.Type;

import java.util.*;
import java.util.stream.Collectors;

public class ListType<T extends Type> extends AbstractDecomposableType implements ComplexType {

    private final List<T> values;

    public ListType() {
        this(Collections.<T>emptyList());
    }

    public ListType(T ... values) {
        this(Arrays.asList(values));
    }

    public ListType(List<T> values) {
        this.values = values;
    }

    public String format(String s) {
        return s;
    }

    public String toFullString() {
        return values.stream()
            .map(Type::toFullString)
            .collect(Collectors.joining(","));
    }

    public Map<String, Type> getTypeMap() {
        Map<String, Type> types = new LinkedHashMap<>();

        int index = 0;
        for (T value : values) {
            types.put(Integer.valueOf(index++).toString(), value);
        }

        return types;
    }

    public String toString() {
        return toFullString();
    }

}

package com.connectorio.bmshub.schedule.type;

import org.eclipse.smarthome.core.types.ComplexType;
import org.eclipse.smarthome.core.types.PrimitiveType;
import org.eclipse.smarthome.core.types.Type;
import org.eclipse.smarthome.core.types.UnDefType;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;

// Represents two values which occur together
public class PairType<K extends Type, V extends Type> extends AbstractDecomposableType {

    private final K key;
    private final V value;

    public PairType() {
        this((K) UnDefType.NULL, (V) UnDefType.NULL);
    }

    public PairType(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Map<String, Type> getTypeMap() {
        return Collections.singletonMap(key.toFullString(), (Type) value);
    }

    public String format(String pattern) {
        return toFullString();
    }

    public String toFullString() {
        return key + "=" + value;
    }
    public String toString() {
        return toFullString();
    }
}

package com.connectorio.bmshub.schedule.type;

import org.eclipse.smarthome.core.types.ComplexType;
import org.eclipse.smarthome.core.types.PrimitiveType;
import org.eclipse.smarthome.core.types.Type;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class AbstractDecomposableType implements DecomposableType {

    public SortedMap<String, PrimitiveType> getConstituents() {
        Map<String, Type> typeMap = getTypeMap();

        final SortedMap<String, PrimitiveType> primitiveTypeMap = new TreeMap<>();

        for (String key : typeMap.keySet()) {
            Type type = typeMap.get(key);
            if (type instanceof ComplexType) {
                SortedMap<String, PrimitiveType> sortedMap = ((ComplexType) type).getConstituents();

                for (Map.Entry<String, PrimitiveType> component : sortedMap.entrySet()) {
                    primitiveTypeMap.put(key + "." + component.getKey(), component.getValue());
                }
            } else if (type instanceof PrimitiveType) {
                primitiveTypeMap.put(key, (PrimitiveType) type);
            } else {
                throw new IllegalArgumentException("Discovered unsupported type while deconstructing complex type: " + type.getClass().getName());
            }
        }

        return primitiveTypeMap;
    }

    @Override
    public String toString() {
        return toFullString();
    }

}

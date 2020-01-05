package com.connectorio.bmshub.schedule.type;

import org.eclipse.smarthome.core.types.ComplexType;
import org.eclipse.smarthome.core.types.Type;

import java.util.Map;

public interface DecomposableType extends ComplexType {

    Map<String, Type> getTypeMap();

}

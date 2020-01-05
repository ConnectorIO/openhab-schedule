package com.connectorio.bmshub.schedule;

import java.util.List;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.Type;
import org.osgi.service.component.annotations.Component;
import com.connectorio.bmshub.api.TypeAndStateParser;
import com.connectorio.bmshub.schedule.type.ScheduleType;

@Component
public class ScheduleTypeAndStateParser implements TypeAndStateParser {

    @Override
    public Type parseType(String typeName, String input) {
        if (ScheduleItemFactory.SCHEDULE.equalsIgnoreCase(typeName) || ScheduleType.class.getSimpleName().equalsIgnoreCase(typeName)) {
            return new ScheduleType();
        }
        return null;
    }

    @Override
    public State parseState(List<Class<? extends State>> types, String state) {
        return types.stream()
            .map(type -> parseType(type.getSimpleName(), state))
            .filter(State.class::isInstance)
            .map(obj -> (State) obj)
            .findFirst().orElse(null);
    }
}

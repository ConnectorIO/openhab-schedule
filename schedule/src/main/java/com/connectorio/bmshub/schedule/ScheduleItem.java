package com.connectorio.bmshub.schedule;

import com.connectorio.bmshub.schedule.type.ScheduleType;
import org.eclipse.smarthome.core.items.GenericItem;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;

import java.util.Collections;
import java.util.List;

public class ScheduleItem extends GenericItem {

    public ScheduleItem(String type, String name) {
        super(type, name);
    }

    @Override
    public List<Class<? extends State>> getAcceptedDataTypes() {
        return Collections.emptyList();
    }

    @Override
    public List<Class<? extends Command>> getAcceptedCommandTypes() {
        return Collections.singletonList(ScheduleType.class);
    }

}

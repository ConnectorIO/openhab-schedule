package com.connectorio.bmshub.schedule.binding;

import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.type.ChannelTypeUID;

public interface Constants {

    String ID = "bactest";

    String THING_TYPE_HVAC_NAME = "hvac";
    ThingTypeUID THING_TYPE_HVAC = new ThingTypeUID(ID, THING_TYPE_HVAC_NAME);

    String CHANEL_TYPE_SCHEDULE_NAME = "schedule";
    ChannelTypeUID CHANEL_TYPE_SCHEDULE = new ChannelTypeUID(ID, CHANEL_TYPE_SCHEDULE_NAME);

}

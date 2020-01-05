package com.connectorio.bmshub.schedule.binding;

import com.connectorio.bmshub.schedule.type.ListType;
import com.connectorio.bmshub.schedule.type.PairType;
import com.connectorio.bmshub.schedule.type.ScheduleType;
import com.connectorio.bmshub.schedule.type.TimeType;
import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.thing.Channel;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.type.ChannelTypeRegistry;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.PrimitiveType;

import java.util.Arrays;
import java.util.List;

public class HvacThingHandler extends BaseThingHandler implements ThingHandler, Constants {

    public HvacThingHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void initialize() {
        updateStatus(ThingStatus.ONLINE);

        List<Channel> channels = getThing().getChannels();
        for (Channel channel : channels) {

        }
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        System.out.println("Handle command " + channelUID + " " + command);

        System.out.println("Posting command to channel " + channelUID.getId());
        if ("weeklySchedule".equals(channelUID.getId())) {
            updateState(channelUID, createSchedule());
        }
    }

    private ScheduleType createSchedule() {
        TimeType morning = new TimeType(6, 0);
        TimeType evening = new TimeType(17, 0);

        PrimitiveType on = OnOffType.ON;
        PrimitiveType off = OnOffType.OFF;

        ScheduleType type = new ScheduleType(Arrays.asList(
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off)),
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off)),
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off)),
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off)),
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off)),
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off)),
                new ListType<>(new PairType<>(morning, on), new PairType<>(evening, off))
        ));
        return type;
    }
}

package com.connectorio.bmshub.schedule;

import com.connectorio.bmshub.schedule.type.ListType;
import com.connectorio.bmshub.schedule.type.PairType;
import com.connectorio.bmshub.schedule.type.ScheduleType;
import com.connectorio.bmshub.schedule.type.TimeType;
import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.types.PrimitiveType;
import org.eclipse.smarthome.core.types.Type;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTypeTest {

    @Test
    void testSchedule() {
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


        System.out.println(type.getConstituents());
    }

}
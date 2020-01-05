package com.connectorio.bmshub.schedule.binding;


import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.osgi.service.component.annotations.Component;

@Component(service = { BACTestHandlerFactory.class, BaseThingHandlerFactory.class, ThingHandlerFactory.class })
public class BACTestHandlerFactory extends BaseThingHandlerFactory implements Constants {

    @Override
    protected ThingHandler createHandler(Thing thing) {
        if (THING_TYPE_HVAC.equals(thing.getThingTypeUID())) {
            return new HvacThingHandler(thing);
        }

        return null;
    }

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return THING_TYPE_HVAC.equals(thingTypeUID);
    }

}

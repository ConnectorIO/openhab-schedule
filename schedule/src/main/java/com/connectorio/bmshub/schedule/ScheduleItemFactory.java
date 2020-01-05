package com.connectorio.bmshub.schedule;

import com.connectorio.bmshub.schedule.ScheduleItem;
import org.eclipse.smarthome.core.items.Item;
import org.eclipse.smarthome.core.items.ItemFactory;
import org.eclipse.smarthome.core.items.ItemUtil;
import org.osgi.service.component.annotations.Component;

@Component
public class ScheduleItemFactory implements ItemFactory {

    public final static String SCHEDULE = "Schedule";

    @Override
    public Item createItem(String itemTypeName, String itemName) {
        if (itemTypeName == null) {
            return null;
        }

        String itemType = ItemUtil.getMainItemType(itemTypeName);
        if (SCHEDULE.equals(itemType)) {
            return new ScheduleItem(itemType, itemName);
        }

        return null;
    }

    @Override
    public String[] getSupportedItemTypes() {
        return new String[] {SCHEDULE};
    }
}

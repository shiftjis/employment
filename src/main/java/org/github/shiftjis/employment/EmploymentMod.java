package org.github.shiftjis.employment;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EmploymentMod implements ModInitializer {
    public static final JobApplicationItem JOB_APPLICATION_ITEM = new JobApplicationItem(new Item.Settings().maxCount(1));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, Identifier.of("employment", "job_application"), JOB_APPLICATION_ITEM);
    }
}

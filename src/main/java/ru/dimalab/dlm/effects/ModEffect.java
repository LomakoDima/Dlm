package ru.dimalab.dlm.effects;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.dimalab.dlm.Dlm;

public class ModEffect {
    public static final DeferredRegister<Effect> EFFECTS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Dlm.MODID);

    public static final RegistryObject<Effect> HIBERNATION = EFFECTS.register("hibernation",
            () -> new Hibernation(EffectType.HARMFUL, 3124687));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}

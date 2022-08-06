package ru.dimalab.dlm;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.dimalab.dlm.blocks.ModBlocks;
import ru.dimalab.dlm.effects.ModEffect;
import ru.dimalab.dlm.enchantment.ModEnchantments;
import ru.dimalab.dlm.event.FurnaceHandler;
import ru.dimalab.dlm.items.ModItems;
import ru.dimalab.dlm.screen.JustScreenKeyHandler;
import ru.hollowhorizon.hc.api.registy.HollowMod;
import ru.hollowhorizon.hc.common.story.events.StoryEventStarter;
import ru.hollowhorizon.hc.common.story.events.StoryRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@HollowMod
@Mod(Dlm.MODID)
public class Dlm {
    public static final String MODID = "dlm";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Dlm() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // BLA_BLA
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEffect.register(eventBus);
        ModEnchantments.register(eventBus);
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);

        eventBus.addListener(this::setup);



        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.register(new JustScreenKeyHandler());
        forgeBus.addListener(JustScreenKeyHandler::onKeyInput);



        //forgeBus.register(new PlayerTickEvent());
        //forgeBus.addListener(PlayerRespawn::playerRespawnClient);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        StoryRegistry.register(FurnaceHandler.class);
    }



    private void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) event.getPlayer();
        int timePlayed = serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.PLAY_ONE_MINUTE));

        if (timePlayed==0) StoryEventStarter.start(serverPlayer, "god_game.furnace_placement");
    }




}

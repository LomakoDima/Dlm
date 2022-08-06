package ru.dimalab.dlm.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.dimalab.dlm.items.ModItems;

import java.util.function.Supplier;

import static ru.dimalab.dlm.Dlm.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    /*public static final RegistryObject<Block> GEM_CUTTING_STATION = registerBlock("lightning_channeler",
            () -> new GemCuttingStationBlock(AbstractBlock.Properties.of(Material.STONE)));*/

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()/*.group(ModItemGroup.TUTORIAL_GROUP)*/));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package ru.dimalab.dlm.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import static ru.hollowhorizon.hc.HollowCore.MODID;

public class JustScreenKeyHandler {
    private static final KeyBinding OPEN_DIMA_SCREEN;

    private static  final String KEY_CATEGORY_MOD = String.format("key.categories.mod.%s", MODID);

    static {
        OPEN_DIMA_SCREEN = new KeyBinding(keyBindName("dima_screen"), 345, KEY_CATEGORY_MOD);
    }

    private static String keyBindName(String name) {
        return String.format("key.%s.%s", MODID, name);
    }

    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (OPEN_DIMA_SCREEN.isActiveAndMatches(InputMappings.getKey(event.getKey(), event.getScanCode())) && Minecraft.getInstance().screen == null) {
            Minecraft.getInstance().setScreen(new JustScreen());
            //Minecraft.getInstance().player.sendMessage(new StringTextComponent("Меню успешно открыто."), Minecraft.getInstance().player.getUUID());


        }
    }

    private void registerKeys() {
        ClientRegistry.registerKeyBinding(OPEN_DIMA_SCREEN);
    }
}

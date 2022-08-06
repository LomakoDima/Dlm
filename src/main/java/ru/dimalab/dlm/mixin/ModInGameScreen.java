package ru.dimalab.dlm.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dimalab.dlm.screen.JustScreen;
import ru.hollowhorizon.hc.client.screens.widget.button.MenuButton;

@Mixin(IngameMenuScreen.class)
public class ModInGameScreen extends Screen {
    private ModInGameScreen() {
        super(new TranslationTextComponent("mainfix"));
    }
    @Inject(method = "createPauseMenu", at = @At("HEAD"))
    private void init(CallbackInfo ci) {
        //this.addButton(new MenuButton(0, 0, 20, 20, new StringTextComponent(""), (button) -> Minecraft.getInstance().setScreen(new JustScreen())));
    }
}

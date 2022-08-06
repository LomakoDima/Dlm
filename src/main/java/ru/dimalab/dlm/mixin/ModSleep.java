package ru.dimalab.dlm.mixin;

import net.minecraft.client.gui.screen.SleepInMultiplayerScreen;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*
public class ModSleep {
    @Mixin(SleepInMultiplayerScreen.class)
    private ModSleep() {
        super(new TranslationTextComponent("mainfix"));
    }
    @Inject(method = "init", at = @At("HEAD"))
    private void init(CallbackInfo ci) {
}}
*/
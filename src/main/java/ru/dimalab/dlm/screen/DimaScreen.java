package ru.dimalab.dlm.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

import static ru.hollowhorizon.hc.HollowCore.MODID;

public class DimaScreen extends Screen {
    protected DimaScreen(){
        super(new StringTextComponent("DIMA SCREEN"));
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new Button(0, 0, 20, 20, new StringTextComponent("button"), (button) -> {
        }));
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float i_dont_know_ticks_navernoe) {
        Minecraft.getInstance().getTextureManager().bind(new ResourceLocation(MODID, "textures/gui/dimascreen.png"));
        blit(stack, 110, 1, 0, 0, 315, 315, 315, 315);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("Работает, не так ли?"), 143, 35, 0xFFFFFF);
    }
}

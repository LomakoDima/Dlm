package ru.dimalab.dlm.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import ru.hollowhorizon.hc.client.screens.util.Alignment;

import static ru.dimalab.dlm.Dlm.MODID;

public class JustScreen extends Screen {
    protected JustScreen(){
        super(new StringTextComponent("DIMA SCREEN"));
    }

    @Override
    protected void init() {
        super.init();
        /*this.addButton(new DimaButton(50, 50, 20, 20, new StringTextComponent(""), (button) -> {
            Minecraft.getInstance().setScreen(new DimaScreen());
        }));*/
        this.addButton(new Button(50, 50, 20, 20, new StringTextComponent(""), (button) -> {

        }));
        this.addButton(new Button(70, 70, 20, 20, new StringTextComponent(""), (button) -> {

        }));
        this.addButton(new Button(0, 0, 20, 20, new StringTextComponent(""), (button) -> {

        }));
        this.addButton(new Button(0, 0, 20, 20, new StringTextComponent(""), (button) -> {

        }));
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float i_dont_know_ticks_navernoe) {
        Minecraft.getInstance().getTextureManager().bind(new ResourceLocation(MODID, "textures/gui/just.png"));
        blit(stack, 15, 0, 0, 0, 380, 380, 380, 380);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("§kRATARETO"), 190, 27, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("§kRATARETO"), 120, 46, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("[Идет процесс дешифрации...]"), 200, 27, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("[Название: §kRATARETO]"), 250, 46, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("[Владелец: §kRATARETO]"), 300, 27, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("[Отправитель: §kRATARETO]"), 290, 46, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("[Владелец: §kRATARETO]"), 260, 27, 0xFFFFFF);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("[Отправитель: §kRATARETO]"), 290, 46, 0xFFFFFF);
        super.render(stack, mouseX, mouseY, i_dont_know_ticks_navernoe);
    }
}

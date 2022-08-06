/*package ru.dimalab.dlm.event;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.hollowhorizon.hc.api.registy.StoryObject;
import ru.hollowhorizon.hc.common.handlers.GUIDialogueHandler;
import ru.hollowhorizon.hc.common.objects.entities.TestEntity;
import ru.hollowhorizon.hc.common.registry.ModEntities;
import ru.hollowhorizon.hc.common.story.HollowStoryHandler;
import ru.hollowhorizon.hc.common.story.dialogues.DialogueTwo;


@StoryObject
public class DialogEventPlayer extends HollowStoryHandler {
    private int counter = 0;
    private BlockPos pos;
    @SubscribeEvent
    public void playerPutsBlock(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) event.getEntity();

            if (serverPlayer.getUUID().equals(this.player.getUUID())) {
                if (event.getPlacedBlock().getBlock() == Blocks.CRAFTING_TABLE) {
                    player.setPos(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                    for (int x = pos.getX() - counter; x < pos.getX() + counter; x++) {
                        for (int y = pos.getY() - counter; y < pos.getY() + counter; y++) {
                            for (int z = pos.getZ() - counter; z < pos.getZ() + counter; z++) {
                            }
                        }}
                                }
                            }
                        }//com.github.alexthe666.iceandfire.entity
                    }
    @Override
    public String getStoryName() {
        return "dialogevent";
}

}*/
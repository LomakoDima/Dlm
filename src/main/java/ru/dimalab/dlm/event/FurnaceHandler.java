package ru.dimalab.dlm.event;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.hollowhorizon.hc.common.story.HollowStoryHandler;
import ru.hollowhorizon.hc.common.story.events.StoryEventStarter;

import java.util.ArrayList;
import java.util.List;

public class FurnaceHandler extends HollowStoryHandler {
    private final int radius = 60;
    private List<OriginalWorldInfo> blocks = new ArrayList<>();
    private boolean invade = false;
    private int counter = 0;
    private int delayCounter = 0;
    private BlockPos pos;
    private Phase phase = Phase.INVADE;

    @SubscribeEvent
    public void onBlockPlacement(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) event.getEntity();

            if (serverPlayer.getUUID().equals(this.player.getUUID())) {
                if (event.getPlacedBlock().getBlock() == Blocks.FURNACE) {
                    this.player.level.setBlockAndUpdate(event.getPos(), Blocks.MAGMA_BLOCK.defaultBlockState());
                    this.pos = event.getPos();
                    this.invade = true;
                } else if (event.getPlacedBlock().getBlock() == Blocks.MAGMA_BLOCK) {
                    LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.player.level);
                    bolt.setPos(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                    bolt.setDamage(20);
                    this.player.level.addFreshEntity(bolt);
                }
            }
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (phase == Phase.INVADE) {
            if (invade) {
                if (delayCounter > 5) {
                    for (int x = pos.getX() - counter; x < pos.getX() + counter; x++) {
                        for (int y = pos.getY() - counter; y < pos.getY() + counter; y++) {
                            for (int z = pos.getZ() - counter; z < pos.getZ() + counter; z++) {
                                BlockPos currentPos = new BlockPos(x, y, z);
                                ServerWorld world = (ServerWorld) this.player.level;

                                if (!world.isEmptyBlock(currentPos) && world.getRandom().nextInt(100) > 95) {
                                    if (world.getBlockState(currentPos).getBlock() != Blocks.NETHERRACK)
                                        blocks.add(new OriginalWorldInfo(currentPos, world.getBlockState(currentPos)));
                                    world.setBlockAndUpdate(currentPos, Blocks.NETHERRACK.defaultBlockState());
                                }

                            }
                        }
                    }
                    counter++;
                    if (counter > radius / 2) {
                        phase = Phase.WAIT;
                        counter = 0;
                    }
                } else {
                    delayCounter += 1;
                }
            }
        } else if (phase == Phase.WAIT) {
            if (counter < 20 * 60 * 3) {
                counter++;
            } else {
                phase = Phase.RESTORE;
            }
        } else {
            for (OriginalWorldInfo info : blocks) {
                this.player.level.setBlockAndUpdate(info.pos, info.state);
            }
            stop();
        }

    }

    @Override
    public void stop() {
        super.stop();
        StoryEventStarter.start(player, "god_game.iron_ore");
    }

    @Override
    public String getStoryName() {
        return "god_game.furnace_placement";
    }

    enum Phase {
        INVADE,
        WAIT,
        RESTORE
    }

    public static class OriginalWorldInfo {
        private final BlockPos pos;
        private final BlockState state;

        public OriginalWorldInfo(BlockPos pos, BlockState state) {
            this.pos = pos;
            this.state = state;
        }
    }

}

package ru.dimalab.dlm.event;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.hollowhorizon.hc.api.registy.StoryObject;
import ru.hollowhorizon.hc.common.story.HollowStoryHandler;

import java.util.ArrayList;
import java.util.List;

@StoryObject
public class IronOreHandler extends HollowStoryHandler {
    private final List<DelayedTask> tasks = new ArrayList<>();
    private int ticker = 0;

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) event.getPlayer();

        if (serverPlayer.getUUID().equals(this.player.getUUID())) {
            if (event.getState().getBlock() == Blocks.IRON_ORE) {


                switch (serverPlayer.getDirection()) {
                    default:
                    case NORTH:
                        for (int z = event.getPos().getZ() - 1; z < event.getPos().getZ() + 1; z++) {
                            for (int y = event.getPos().getY() + 3; y > event.getPos().getY(); y--) {
                                for (int x = event.getPos().getX(); x < event.getPos().getX() + 20; x++) {
                                    int finalY = y;
                                    int finalX = x;
                                    int finalZ = z;
                                    tasks.add(() -> player.level.setBlockAndUpdate(new BlockPos(finalX, finalY, finalZ), Blocks.AIR.defaultBlockState()));

                                }
                            }
                        }
                        break;
                    case SOUTH:
                        for (int z = event.getPos().getZ() + 1; z > event.getPos().getZ() - 1; z--) {
                            for (int y = event.getPos().getY() + 3; y > event.getPos().getY(); y--) {
                                for (int x = event.getPos().getX(); x > event.getPos().getX() - 20; x--) {
                                    int finalY = y;
                                    int finalX = x;
                                    int finalZ = z;
                                    tasks.add(() -> player.level.setBlockAndUpdate(new BlockPos(finalX, finalY, finalZ), Blocks.AIR.defaultBlockState()));
                                }
                            }
                        }
                        break;
                    case EAST:
                        for (int x = event.getPos().getX() - 1; x < event.getPos().getX() + 1; x++) {
                            for (int y = event.getPos().getY() + 3; y > event.getPos().getY(); y--) {
                                for (int z = event.getPos().getZ(); z < event.getPos().getZ() + 20; z++) {
                                    int finalY = y;
                                    int finalX = x;
                                    int finalZ = z;
                                    tasks.add(() -> player.level.setBlockAndUpdate(new BlockPos(finalX, finalY, finalZ), Blocks.AIR.defaultBlockState()));
                                }
                            }
                        }
                        break;
                    case WEST:
                        for (int x = event.getPos().getX() + 1; x > event.getPos().getX() - 1; x--) {
                            for (int y = event.getPos().getY() + 3; y > event.getPos().getY(); y--) {
                                for (int z = event.getPos().getZ(); z > event.getPos().getZ() - 20; z--) {
                                    int finalY = y;
                                    int finalX = x;
                                    int finalZ = z;
                                    tasks.add(() -> player.level.setBlockAndUpdate(new BlockPos(finalX, finalY, finalZ), Blocks.AIR.defaultBlockState()));
                                }
                            }
                        }
                        break;

                }


            }
        }

    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (tasks.size()>0) {
            if (ticker < 3) ticker++;
            else {
                ticker = 0;
                tasks.get(0).execute();
                tasks.remove(0);
            }
        }
    }

    @Override
    public String getStoryName() {
        return "ggu.iron_ore";
    }

    public interface DelayedTask {
        void execute();
    }
}

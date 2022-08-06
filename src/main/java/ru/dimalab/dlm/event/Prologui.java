package ru.dimalab.dlm.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import ru.hollowhorizon.hc.api.registy.StoryObject;
import ru.hollowhorizon.hc.common.story.dialogues.DialogueBuilder;
import ru.hollowhorizon.hc.common.story.dialogues.DialogueComponent;
import ru.hollowhorizon.hc.common.story.dialogues.HollowDialogue;
import ru.hollowhorizon.hc.common.story.dialogues.IHollowDialogue;

import java.util.function.Supplier;

@StoryObject
public class Prologui implements IHollowDialogue {
    @Override
    public HollowDialogue build(DialogueBuilder builder){
        return builder
                .add(DialogueComponent.TEXT.create()
                        .setCharacterName("Dima")
                        .setText("Привет!")
                        .setCharacterEntities(() -> new ZombieEntity(EntityType.ZOMBIE, Minecraft.getInstance().level))
                )
                .build();
    }

    @Override
    public String getName(){return "dialogui";}
}

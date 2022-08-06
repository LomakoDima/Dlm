/*package ru.dimalab.dlm;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import ru.hollowhorizon.hc.api.registy.HollowRegister;

import static ru.dimalab.dlm.Dlm.MODID;

public class ModEntity {
    @HollowRegister(model = "hc:models/animstion.fbx")
    public static final EntityType<TestEntityEvent> testEntityEvent = createEntity(
            TestEntityEvent::new,
            EntityClassification.CREATURE, 1F, 2F, "testentity"
    );

    private static <T extends Entity> EntityType<T> createEntity(EntityType.IFactory<T> entity, EntityClassification classification, float width, float height, String regName) {
        return EntityType.Builder.of(entity, classification).sized(width, height).build(MODID + ":" + regName);
    }
}*/
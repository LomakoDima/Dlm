package ru.dimalab.dlm.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.dimalab.dlm.effects.ModEffect;
import ru.hollowhorizon.hc.api.registy.StoryObject;
import ru.hollowhorizon.hc.common.story.HollowStoryHandler;

@StoryObject
public class PlayerTickEvent extends HollowStoryHandler {
    private int tickgame = 0;
    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            tickgame+=1;
            if (tickgame == 1500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fВнимание всем жителям <<Алотерры>>!"), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 1600) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fВ зоне <<А>> через 30 минут начнутся профилактические работы."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 1900) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fПожалуйста, соблюдайте инструкции и проследуйте в ближайший к вам сектор ожидания."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 2200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fВсе граждане, не покинувшие зону, будут уничтожены."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 2500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fПовторяю: все граждане, не покинувшие зону, будут уничтожены."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 2800) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fВремени до перезагрузки - 29 минут."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8000) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fРаботы начнутся через 10 секунд."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f9..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f8..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8300) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f7..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8400) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f6..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f5..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8600) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f4..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8700) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f3..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8800) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f2..."), Minecraft.getInstance().player.getUUID());
            }

            if (tickgame == 8900) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §f1..."), Minecraft.getInstance().player.getUUID());
                player.addEffect(new EffectInstance(Effects.BLINDNESS, 1000));
                player.addEffect(new EffectInstance(Effects.POISON, 1000));
                player.addEffect(new EffectInstance(Effects.HARM, 1000));
            }
            if (tickgame == 9100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fРаботы завершены."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 9300) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fВсем гражданам вернуться к выполнению ежедневных алгоритмов."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 9500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] §fИ помните: Империя заботится о Вас!"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15000) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Зафиксирован незарегистрированный автономный организм класса R-700."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Все организмы, не прошедшие регистрацию, подлежат проверке."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Организму оставаться на месте до выяснения обстоятельств."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15300) {
                Vector3d playerPos = player.position();
                String pos = playerPos.x + ", " + playerPos.y + ", " + playerPos.z + ".";
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Ваши координаты: " + pos), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15400) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Отряд ликвидаторов уже в пути."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Повторяю."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15600) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Неизвестный голос] Отряд уже в пути, ожидайте прибытия."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15700) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 10 секунд."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15800) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 9 секунд."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 15900) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 8 секунд."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16000) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 7 секунд."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 6 секунд."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 5 секунд."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16300) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 4 секунды."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16400) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 3 секунды."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 2 секунды."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 16600) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§bДо прибытия: 1 секунда."), Minecraft.getInstance().player.getUUID());
                player.addEffect(new EffectInstance(Effects.BLINDNESS, 500));
            }
            if (tickgame == 25000) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Обнаружен неизвестный нейропротокол] "), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Название: §kДаливарика]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Владелец: §kДаливарика]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25300) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Отправитель: §kДаливарика]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25400) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Дата отправки: 17.04.2031]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Дата: §k17.04.2400§f:§kДаливарика]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25600) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Чтение содержимого...]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25700) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Чтение недоступно]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25800) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Сообщение зашифровано]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 25900) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Запушен автоматический подбор ключа]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 26000) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Подходящий ключ найден: DALIVARIKA]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 26100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Ключ принят]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 26200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[Система уведомлений] §f[Начинаю процесс дешифрации...]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 26300) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§6Для того чтобы прочитать сообщение нажмите 'левый alt'."), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30000) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Вы активировали запрос на реконструкцию событий]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30100) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Направляю запрос в блок памяти...]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30200) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Инициализация...]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30300) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Критическая ошибка #17]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30400) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Данные повреждены]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30500) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Отсутствует деталь Гамма]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30600) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Ошибка чтения]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30700) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Данные повреждены]"), Minecraft.getInstance().player.getUUID());
            }
            if (tickgame == 30800) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("§b[???] §f[Активирован протокол гибернации]"), Minecraft.getInstance().player.getUUID());
                player.addEffect(new EffectInstance(ModEffect.HIBERNATION.get(), 100000));
            }
        }
    }
    @Override
    public String getStoryName() {
        return "tickmessage";
    }
}


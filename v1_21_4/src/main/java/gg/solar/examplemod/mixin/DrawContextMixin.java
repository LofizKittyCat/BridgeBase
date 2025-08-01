package gg.solar.examplemod.mixin;

import gg.solar.bridge.minecraft.IDrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DrawContext.class)
public abstract class DrawContextMixin implements IDrawContext {

    @Shadow public abstract int drawText(TextRenderer textRenderer, @Nullable String text, int x, int y, int color, boolean shadow);

    @Override
    public void drawText(@NotNull String text, float x, float y, int color, boolean shadow) {
        this.drawText(MinecraftClient.getInstance().textRenderer, text, (int) x, (int) y, color, shadow);
    }
}

package gg.solar.bridge.minecraft

import net.minecraft.client.MinecraftClient

/**
 * This Impl Is Only Used For Versions Using LWJGL 2, This Is For Compatibility Between Versions That Render Text With mc.textRenderer and Ones That Use DrawContext
 */
class DrawContextImpl : IDrawContext {

    override fun drawText(text: String, x: Float, y: Float, color: Int, shadow: Boolean) {
        MinecraftClient.getInstance().textRenderer.draw(text, x, y, color, shadow)
    }
}
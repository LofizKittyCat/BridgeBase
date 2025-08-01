package gg.solar.bridge.minecraft

import net.minecraft.client.MinecraftClient

class MinecraftImpl : IMinecraft {

    override fun getCurrentFps(): Int {
        return MinecraftClient.getCurrentFps()
    }

    override val width: Int = MinecraftClient.getInstance().width

    override val height: Int = MinecraftClient.getInstance().height

    override fun getLegacyDrawContext(): IDrawContext? {
        return DrawContextImpl()
    }
}
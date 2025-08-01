package gg.solar.bridge.minecraft

import net.minecraft.client.MinecraftClient

class MinecraftImpl : IMinecraft {

    override fun getCurrentFps(): Int {
        return MinecraftClient.getInstance().currentFps
    }

    override val width: Int
        get() = MinecraftClient.getInstance().window.width

    override val height: Int
        get() = MinecraftClient.getInstance().window.height

    /**
     * Unused As 1.21 Isn't A Legacy Version
     */
    override fun getLegacyDrawContext(): IDrawContext? {
        return null
    }
}
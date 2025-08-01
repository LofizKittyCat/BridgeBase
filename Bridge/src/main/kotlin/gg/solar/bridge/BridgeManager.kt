package gg.solar.bridge

import gg.solar.bridge.minecraft.IMinecraft

/**
 * Manages Bridge Classes As Bridges Can't & Don't Have Single-tones, egc: MinecraftClient.getInstance()
 */
object BridgeManager {

    private var _minecraftBridge: IMinecraft? = null

    fun init(minecraft: IMinecraft) {
        _minecraftBridge = minecraft
    }

    /**
     * Returns A Immutable Minecraft Bridge Object Ensuring No Null Pointer's
     */
    fun getMinecraft(): IMinecraft {
        return _minecraftBridge ?: throw NullPointerException("Failed To Initialize Minecraft Bridge!")
    }
}
package gg.solar.bridge.minecraft

interface IMinecraft {

    fun getCurrentFps(): Int

    val width: Int

    val height: Int

    fun getLegacyDrawContext(): IDrawContext?
}
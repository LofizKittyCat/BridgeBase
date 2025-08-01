package gg.solar.examplemod

import gg.solar.bridge.BridgeManager
import gg.solar.bridge.minecraft.IDrawContext
import gg.solar.bridge.minecraft.MinecraftImpl
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback

class ModInit : ModInitializer {

    override fun onInitialize() {
        BridgeManager.init(MinecraftImpl())
        ExampleMod.getInstance().onInit()

        HudRenderCallback.EVENT.register { context, counter ->
            ExampleMod.getInstance().onRender(context as IDrawContext)
        }
    }
}
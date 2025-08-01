package gg.solar.examplemod

import gg.solar.bridge.BridgeManager
import gg.solar.bridge.minecraft.MinecraftImpl
import net.fabricmc.api.ModInitializer
import net.legacyfabric.fabric.api.client.rendering.v1.HudRenderCallback

class ModInit : ModInitializer {

    /**
     * Mod Init Is Called After All Bridge's Are Set up (for obvious reasons)
     */
    override fun onInitialize() {
        BridgeManager.init(MinecraftImpl())
        ExampleMod.getInstance().onInit()

        HudRenderCallback.EVENT.register { client, tickDelta ->
            ExampleMod.getInstance().onRender(BridgeManager.getMinecraft().getLegacyDrawContext()!!)
        }
    }
}
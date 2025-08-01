package gg.solar.examplemod

import gg.solar.bridge.BridgeManager
import gg.solar.bridge.minecraft.IDrawContext

class ExampleMod {

    fun onInit() {
        println("Hello Fabric World!")
    }

    /**
     * Rendering Example
     */
    fun onRender(context: IDrawContext) {
        context.drawText("FPS: ${BridgeManager.getMinecraft().getCurrentFps()}", 5f, 5f, -1, true)
    }

    companion object {

        private val inst by lazy { ExampleMod() }

        @JvmStatic
        fun getInstance(): ExampleMod {
            return inst
        }
    }
}
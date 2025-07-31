package gg.solar.examplemod

import net.fabricmc.api.ModInitializer

/**
 * @author iLofiz
 */
class ExampleMod : ModInitializer {

    override fun onInitialize() {
        println("Hello Fabric world!")
    }

    /* Static Instancing */
    companion object {

        private val inst by lazy { ExampleMod() }

        @JvmStatic
        fun getInstance(): ExampleMod {
            return inst
        }
    }
}
package rocks.rdil.simpleconfig

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import rocks.rdil.simpleconfig.GsonExt.gson
import java.io.File

class ConfigHandler(private val file: File) {
    var cfg = JsonObject()

    /**
     * Create a list of the registered configurations. To add to this use ConfigHandler#register(config)
     */
    private val configObjs = mutableListOf<Config>()

    fun register(config: Config) {
        configObjs.add(config)
        config.javaClass.declaredFields
                .filter { it.isAnnotationPresent(Configuration::class.java) }
                .forEach {
                    if (!it.isAccessible) {
                        it.isAccessible = true
                    }
                    val configuration = it.getAnnotation(Configuration::class.java)
                    // Check if the configuration on has the alt and the alt, is not empty and the configuration does not contain the name
                    if (cfg.has(configuration.alt) && configuration.alt.isNotEmpty() && !cfg.has(it.name)) {
                        // Check if the configuration contains the alt of the annotation
                        if (cfg[configuration.alt].asJsonObject.has(configuration.alt)) {
                            cfg.add(it.name, cfg[configuration.alt].asJsonObject[configuration.alt])
                        }
                    }
                    if (cfg.has(it.name)) {
                        try {
                            // Set the variable to the name from the json
                            it[config] = gson.fromJson(cfg[it.name], it.type)
                        } catch (e: Exception) {
                            error("Config options cannot be final!")
                        }
                    }
                }
    }

    private fun loadConfigurationToJsonFile(config: Config) {
        config.javaClass.declaredFields
                .filter { it.isAnnotationPresent(Configuration::class.java) }
                .forEach {
                    if (!it.isAccessible) {
                        it.isAccessible = true
                    }
                    cfg.add(it.name, gson.toJsonTree(it[config], it.type))
                }
    }

    fun save() {
        configObjs.forEach { loadConfigurationToJsonFile(it) }
        if (!file.exists()) {
            file.createNewFile()
        }

        file.let { it.writeText(gson.toJson(cfg)) }
    }

    init {
        if (file.exists()) {
            cfg = JsonParser().parse(file.let { it.readText() }).asJsonObject
        } else {
            save()
        }
    }
}

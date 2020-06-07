package rocks.rdil.simpleconfig

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.File

class ConfigHandler(private val file: File) {
    private var cfg = JsonObject()

    /**
     * Create a list of the registered configurations. To add to this use ConfigHandler#register(config)
     */
    private val configObjs = mutableListOf<Config>()

    fun register(config: Config) {
        configObjs.add(config)
        // Filter through all the fields and check if  the Configuration annotation is present.
        config.javaClass.declaredFields
            .filter { it.isAnnotationPresent(Configuration::class.java) }
            .forEach {
                if (!it.isAccessible) {
                    it.isAccessible = true
                }
                // Create an instance of the Configuration class
                val configuration = it.getAnnotation(Configuration::class.java)
                // Check if the configuration on has the alt and the alt  is not empty and the configuration does not contain the name
                if (cfg.has(configuration.alt) && configuration.alt.isNotEmpty() && !cfg.has(it.name)) {
                    // Check if the configuration contains the alt of the annotation
                    if (cfg[configuration.alt].asJsonObject.has(configuration.alt))
                    // Add to the config
                        cfg.add(it.name, cfg[configuration.alt].asJsonObject[configuration.alt])
                }
                // Check if the config contains the name of the variable
                if (cfg.has(it.name)) {
                    try {
                        // Set the variable to the name from the json .
                        it[config] = gson.fromJson(cfg[it.name], it.type)
                    } catch (e: Exception) {
                        // Throw an error to say that Config Opts can not be final
                        error("Config Opts cannot be final!")
                    }
                }
            }
    }

    private fun loadConfigurationToJsonFile(config: Config) {
        // Filter through all the declared fields and check if the Configuration annotation is present.
        config.javaClass.declaredFields
            .filter { it.isAnnotationPresent(Configuration::class.java) }
            .forEach {
                if (!it.isAccessible) {
                    it.isAccessible = true
                }
                // Add the option to the config
                cfg.add(it.name, gson.toJsonTree(it[config], it.type))
            }
    }

    fun save() {
        configObjs.forEach { loadConfigurationToJsonFile(it) }
        //  If the file doesn't exist create a new file
        if (!file.exists()) {
            file.createNewFile()
        }

        // Write a new file
        file.let { it.writeText(gson.toJson(cfg)) }
    }

    init {
        // If  the file exists set the current loaded configuration file
        // to the config file else create a new one with the output of "{}"
        if (file.exists()) {
            cfg = JsonParser.parseString(file.let { it.readText() }).asJsonObject
        } else {
            save()
        }
    }
}


// Create a superclass for Configs. May be extended later
open class Config

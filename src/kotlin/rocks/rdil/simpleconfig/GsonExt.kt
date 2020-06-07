package rocks.rdil.simpleconfig

import com.google.gson.Gson
import com.google.gson.GsonBuilder

val gson: Gson = GsonBuilder()
    .serializeNulls()
    .disableHtmlEscaping()
    .setPrettyPrinting()
    .create()
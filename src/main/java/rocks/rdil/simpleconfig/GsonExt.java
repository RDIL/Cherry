package rocks.rdil.simpleconfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExt {
    public static final Gson gson = new GsonBuilder()
        .serializeNulls()
        .disableHtmlEscaping()
        .setPrettyPrinting()
        .create();
}
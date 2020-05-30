package rocks.rdil.cherry.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import lombok.Cleanup;

public class ConfigManager {
    public static final File file = new File("cherry-config.txt");
    public Config config;
    public static final ConfigManager instance = new ConfigManager();

    public ConfigManager() {
        try {
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                @Cleanup BufferedReader br = new BufferedReader(fr);
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }

                this.config = this.fromConfigFile(builder.toString());
            } else {
                this.config = defaultConfig();
                this.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Config fromConfigFile(String config) {
        String[] strings = config.replace("Config(", "").replace(")", "").split(",");
        Config c = new Config();

        for (String string : strings) {
            String key = string.split("=")[0];
            String value = string.split("=")[1];

            if (key.equals("toggleSprint")) {
                c.setToggleSprint(value);
            }
        }

        return c;
    }

    public void save() {
        try {
            file.createNewFile();
            @Cleanup FileWriter fw = new FileWriter(file);
            @Cleanup BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.config.toString());
        } catch (Exception ignored) {}
    }

    Config defaultConfig() {
        Config c = new Config();
        c.setToggleSprint("false");
        return c;
    }
}

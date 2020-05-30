package rocks.rdil.cherry.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import lombok.Cleanup;

public class ConfigManager {
    private final File file;
    private Config config;

    public ConfigManager(File f) {
        this.file = f;
        try {
            if (f.exists()) {
                FileReader fr = new FileReader(file);
                @Cleanup BufferedReader br = new BufferedReader(fr);
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }

                this.config = this.fromConfigFile(builder.toString());
            } else {
                this.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Config fromConfigFile(String config) {
        String[] strings = config.replace("Config(", "").replace(")", "").split(",");
        Config c = new Config();

        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].split("=")[0];
            String value = strings[i].split("=")[1];

            if (key == "toggleSprint") {
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

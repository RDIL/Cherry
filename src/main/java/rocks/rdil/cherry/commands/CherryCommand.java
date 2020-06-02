package rocks.rdil.cherry.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.LiteralText;

import java.util.Arrays;
import java.util.List;

public class CherryCommand {
    public CherryCommand() {
        this.register();
    }

    static List<String> optionNames() {
        return Arrays.asList("ToggleSprint", "EnableTutorialPopups");
    }

    void register() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) ->
            dispatcher.register(
                CommandManager.literal("cherry").executes(ctx -> {
                    MinecraftClient.getInstance().openScreen(new CherryGui());
                    return 0;
                })
            )
        ));
    }
}

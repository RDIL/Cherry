package rocks.rdil.cherry.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.LiteralText;
import rocks.rdil.cherry.config.ConfigManager;

import java.util.Arrays;
import java.util.List;

import static com.mojang.brigadier.arguments.StringArgumentType.string;

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
                    CommandManager.literal("cherry")
                            .then(CommandManager.argument("feature", string())
                                    .suggests(SuggestionsUtil.opts(optionNames()))
                                    .executes((ctx) -> {
                                if (StringArgumentType.getString(ctx, "feature").equals("ToggleSprint")) {
                                    if (ConfigManager.instance.config.getToggleSprint().equals("true")) {
                                        ConfigManager.instance.config.setToggleSprint("false");
                                    } else {
                                        ConfigManager.instance.config.setToggleSprint("true");
                                    }
                                    ConfigManager.instance.save();
                                }

                                if (StringArgumentType.getString(ctx, "feature").equals("EnableTutorialPopups")) {
                                    if (ConfigManager.instance.config.getEnableTutorialPopups().equals("true")) {
                                        ConfigManager.instance.config.setEnableTutorialPopups("false");
                                    } else {
                                        ConfigManager.instance.config.setToggleSprint("true");
                                    }
                                }

                                ctx.getSource().sendFeedback(new LiteralText("Done!"), false);

                                return 0;
                            }))
                    .executes(ctx -> {
                        ctx.getSource().sendError(new LiteralText("This command enables or disables a Cherry feature. Usage: /cherry <feature>"));
                        return 1;
                    })
            )
        ));
    }
}

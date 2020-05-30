package rocks.rdil.cherry;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import rocks.rdil.cherry.config.ConfigManager;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import static com.mojang.brigadier.arguments.StringArgumentType.string;

public class CherryCommand {
    public CherryCommand() {
        this.register();
    }

    private static CompletableFuture<Suggestions> getSuggestionsBuilder(SuggestionsBuilder builder, List<String> list) {
        String remaining = builder.getRemaining().toLowerCase(Locale.ROOT);

        if (list.isEmpty()) {
            return Suggestions.empty();
        }

        for (String str : list) {
            if (str.toLowerCase(Locale.ROOT).startsWith(remaining)) {
                builder.suggest(str);
            }
        }
        return builder.buildFuture();
    }

    private static SuggestionProvider<ServerCommandSource> opts() {
        return (ctx, builder) -> getSuggestionsBuilder(builder, Arrays.asList("ToggleSprint"));
    }

    void register() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) ->
            dispatcher.register(
                    CommandManager.literal("cherry")
                            .then(CommandManager.argument("feature", string())
                                    .suggests(opts())
                                    .executes((ctx) -> {
                                if (StringArgumentType.getString(ctx, "feature").equals("ToggleSprint")) {
                                    if (ConfigManager.instance.config.getToggleSprint().equals("true")) {
                                        ConfigManager.instance.config.setToggleSprint("false");
                                    } else {
                                        ConfigManager.instance.config.setToggleSprint("true");
                                    }
                                    ConfigManager.instance.save();
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

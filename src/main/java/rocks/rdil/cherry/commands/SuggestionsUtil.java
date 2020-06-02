package rocks.rdil.cherry.commands;

import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.server.command.ServerCommandSource;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class SuggestionsUtil {
    static CompletableFuture<Suggestions> getSuggestionsBuilder(SuggestionsBuilder builder, List<String> list) {
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

    static SuggestionProvider<ServerCommandSource> opts(List<String> o) {
        return (ctx, builder) -> SuggestionsUtil.getSuggestionsBuilder(builder, o);
    }
}

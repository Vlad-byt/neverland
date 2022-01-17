package app.presenters;

import app.Player;
import app.Stat;

import java.util.stream.Collectors;

public class PlayerPresenter {
    Player player;

    public PlayerPresenter(Player player) {
        this.player = player;
    }

    public String stats() {
        return player.stats.values().stream().map(Stat::toString).collect(Collectors.joining("\n"));
    }
}

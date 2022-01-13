package app;

import java.util.HashMap;

class Player {
    boolean alive = true;
    HashMap<String, Stat> stats = new HashMap<>();

    Player() {
        stats.put("Population", new Stat("Population", 100));
        stats.put("Happiness", new Stat("Happiness", 100));
        stats.put("Money", new Stat("Money", 100));
    }
}

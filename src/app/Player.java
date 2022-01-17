package app;

import java.util.HashMap;

public class Player {
    public boolean alive = true;
    public HashMap<String, Stat> stats = new HashMap<>();

    Player() {
        stats.put("Population", new Stat("Population", 100));
        stats.put("Happiness", new Stat("Happiness", 100));
        stats.put("Money", new Stat("Money", 100));
    }
}

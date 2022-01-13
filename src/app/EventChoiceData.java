package app;

import java.util.HashMap;

class EventChoiceData {
    String name;
    int value;
    boolean operation;

    public void perform(HashMap<String, Stat> stats) {
        Stat stat = stats.get(this.name);

        if (operation) {
            stat.value += value;
        } else {
            stat.value -= value;
        }
    }
}

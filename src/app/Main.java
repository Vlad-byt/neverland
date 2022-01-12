package app;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Game().start();
    }
}

class Game {
    Scanner input = new Scanner(System.in);

    public void start() throws FileNotFoundException {
        Gson gson = new Gson();
        StoreEvents storeEvents = gson.fromJson(new FileReader("./src/app/events.json"), StoreEvents.class);
        Player player = new Player();

        gameLoop(player, storeEvents.events);
    }

    private void gameLoop(Player player, ArrayList<Event> events) {
        while (player.alive) {
            Random rand = new Random();
            Event event = events.get(rand.nextInt(events.size()));

            System.out.println(event.msg);

            String answer = input.nextLine();

            if (answer.equals("y")) {
                if (event.yesChoiceData.length > 0) {
                    for (int i = 0; i < event.yesChoiceData.length; i++) { event.yesChoiceData[i].perform(player.stats); }
                }
            } else {
                if (event.noChoiceData.length > 0) {
                    for (int i = 0; i < event.yesChoiceData.length; i++) { event.noChoiceData[i].perform(player.stats); }
                }
            }

            System.out.println(player.stats.get("Population").value);
            System.out.println(player.stats.get("Happiness").value);
            System.out.println(player.stats.get("Money").value);
        }
    }
}

class Player {
    boolean alive = true;
    HashMap<String, Stat> stats = new HashMap<>();

    Player() {
        stats.put("Population", new Stat("Population", 100));
        stats.put("Happiness", new Stat("Happiness", 100));
        stats.put("Money", new Stat("Money", 100));
    }
}

class Stat {
    String name;
    int    value;

    Stat(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

class StoreEvents {
    ArrayList<Event> events;
}

class Event {
    String msg;
    EventChoiceData[] yesChoiceData;
    EventChoiceData[] noChoiceData;
}

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


//abstract class Game {
//    Event[] events;
//
//    Game(Event[] events) {}
//
//    public void start() {}
//
//    public void end() {}
//
//    private void gameLoop() {}
//
//    private void init() {}
//}
//
//abstract class Player {
//    StatsManager stats;
//    Scanner input;
//
//    Player(Stat[] stats) {}
//}
//
//abstract class Event {
//    Stat[] statInfluence;
//    String msg;
//
//    Event(String msg, Stat[] statInfluence) {}
//
//    private void condition() {}
//    private void afterEvent() {}
//}
//
//abstract class StatsManager {
//    Stat[] stats;
//
//    StatsManager(Stat[] stats) {}
//
//    public void changeValue(Stat stat, int newValue);
//}
//
//abstract class Stat {
//    String name;
//    int    value;
//
//    Stat(String name, Integer initialValue) {}
//
//    public void setValue(int value) {}
//}
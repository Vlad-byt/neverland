package app;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Game().start();
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
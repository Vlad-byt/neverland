package app;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
                    for (int i = 0; i < event.yesChoiceData.length; i++) {
                        event.yesChoiceData[i].perform(player.stats);
                    }
                }
            } else {
                if (event.noChoiceData.length > 0) {
                    for (int i = 0; i < event.yesChoiceData.length; i++) {
                        event.noChoiceData[i].perform(player.stats);
                    }
                }
            }

            System.out.println(player.stats.get("Population").value);
            System.out.println(player.stats.get("Happiness").value);
            System.out.println(player.stats.get("Money").value);
        }
    }
}

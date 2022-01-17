package app;

import app.infrastructure.ConsoleManager;
import app.infrastructure.IOManager;
import app.presenters.EventPresenter;
import app.presenters.PlayerPresenter;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

class Game {
    Player player = new Player();
    IOManager ioManager = new ConsoleManager();
    StoreEvents storeEvents = new Gson().fromJson(new FileReader("./src/app/events.json"), StoreEvents.class);

    Game() throws FileNotFoundException {
    }

    public void start() {
        gameLoop();
    }

    private void gameLoop() {
        while (player.alive) {
            Event randomEvent = getRandomEvent();
            showEventMessage(randomEvent);

            String answer = ioManager.input();
            randomEvent.performEffectsDueToChoice(answer, player.stats);

            showPlayerStats();
        }
    }

    private Event getRandomEvent() {
        Random rand = new Random();
        return storeEvents.events.get(rand.nextInt(storeEvents.events.size()));
    }

    private void showEventMessage(Event event) {
        EventPresenter eventPresenter = new EventPresenter(event);
        ioManager.output(eventPresenter.message());
    }

    private void showPlayerStats() {
        PlayerPresenter playerPresenter = new PlayerPresenter(player);
        ioManager.output(playerPresenter.stats());
    }
}

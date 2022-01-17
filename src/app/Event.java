package app;

import java.util.Arrays;
import java.util.HashMap;

public class Event {
    public String msg;
    public EventChoiceData[] yesChoiceData;
    public EventChoiceData[] noChoiceData;

    //TODO: Если выделить этот класс как модель куда вынести код ниже? Service object?
    public void performEffectsDueToChoice(String choice, HashMap<String, Stat> playerStats) {
        EventChoiceData[] choiceData = choice.equals("y") ? yesChoiceData : noChoiceData;
        if (choiceData.length <= 0) return;

        Arrays.stream(choiceData).forEach(data -> data.perform(playerStats));
    }
}

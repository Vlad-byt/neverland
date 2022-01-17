package app.presenters;

import app.Event;

public class EventPresenter {
    Event event;

    public EventPresenter(Event event) {
        this.event = event;
    }

    public String message() {
        return event.msg;
    }
}

package tn.marateck.rct.services;

import tn.marateck.rct.models.Event;

import java.util.List;

public interface EventServiceIn {
    Event createEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(Long id);
    void deleteEvent(Long id);
}

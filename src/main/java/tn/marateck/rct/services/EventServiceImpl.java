package tn.marateck.rct.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.marateck.rct.models.Event;
import tn.marateck.rct.repositories.EventRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventServiceIn{

    private final EventRepo eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findByActiveTrue();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

package tn.marateck.rct.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.marateck.rct.models.Event;
import tn.marateck.rct.services.EventServiceIn;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventServiceIn eventService;

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','COACH','GROUP_ADMIN')")
    public Event create(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public void delete(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}

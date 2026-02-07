package tn.marateck.rct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.marateck.rct.models.Event;
import tn.marateck.rct.models.EventType;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findByActiveTrue();

    List<Event> findByType(EventType type);

    List<Event> findByGroupName(String groupName);
}

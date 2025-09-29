package se331.lab.service;

import org.springframework.data.domain.*;
import se331.lab.entity.Event;

public interface EventService {
    Integer getEventSize();
    Page<Event> getAllEvents(Pageable pageable);
    Page<Event> getEvents(String title, Pageable pageable);
    Event getEventId(Long id);
    Event save(Event event);
}

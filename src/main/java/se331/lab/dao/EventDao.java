package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Event;

public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Pageable pageable);
    Event getEvent(Long id);
    Event save(Event event);
    Page<Event> getEvents(String title, Pageable pageable);
}

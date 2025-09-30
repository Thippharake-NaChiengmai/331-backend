package se331.lab.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import se331.lab.dao.EventDao;
import se331.lab.dao.OrganizerDao;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    @Autowired
    final EventDao eventDao;
    final OrganizerDao organizerDao;
    
    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventDao.getEvents(pageable);
    }

    @Override
    public Page<Event> getEvents(String title, Pageable pageable) {
        return eventDao.getEvents(title, pageable);
    }

    @Override
    public Event getEventId(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        Organizer organizer =
        organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        return eventDao.save(event);
    }
}

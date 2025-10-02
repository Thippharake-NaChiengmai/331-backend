package se331.lab.dao;

import org.springframework.data.domain.Pageable;
import se331.lab.entity.Organizer;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrganizerDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Optional<Organizer> findById(Long id);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}

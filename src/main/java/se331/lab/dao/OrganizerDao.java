package se331.lab.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import se331.lab.entity.Organizer;
import org.springframework.data.domain.Page;

public interface OrganizerDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}

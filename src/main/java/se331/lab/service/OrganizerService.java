package se331.lab.service;

import se331.lab.entity.Organizer;
import org.springframework.data.domain.Page;

public interface OrganizerService {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}

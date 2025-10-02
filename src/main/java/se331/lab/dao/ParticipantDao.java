package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Participants;

import java.util.Optional;

public interface ParticipantDao {
    Integer getParticipantSize();
    Page<Participants> getParticipants(Pageable pageRequest);
    Optional<Participants> findById(Long id);
    Participants getParticipant(Long id);
    Participants save(Participants participant);
}

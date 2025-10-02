package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.entity.Participants;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participants, Long> {
    List<Participants> findAll();
}

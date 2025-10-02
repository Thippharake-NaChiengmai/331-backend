package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Participants;
import se331.lab.repository.ParticipantRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class ParticipantDaoImpl implements ParticipantDao {
    final ParticipantRepository participantRepository;

    @Override
    public Page<Participants> getParticipants(Pageable pageable) {
        return participantRepository.findAll(pageable);
    }

    @Override
    public Integer getParticipantSize() {
        return (int) participantRepository.count();
    }

    @Override
    public Participants getParticipant(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    @Override
    public Participants save(Participants participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Optional<Participants> findById(Long id) {
        return participantRepository.findById(id);
    }
}

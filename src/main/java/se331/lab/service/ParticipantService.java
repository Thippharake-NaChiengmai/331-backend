package se331.lab.service;

import se331.lab.entity.Participants;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ParticipantService {
    Integer getParticipantSize();
    List<Participants> getAllParticipants();
    Page<Participants> getParticipants(Integer page, Integer pageSize);
    Participants getParticipant(Long id);
    Participants save(Participants participant);
}

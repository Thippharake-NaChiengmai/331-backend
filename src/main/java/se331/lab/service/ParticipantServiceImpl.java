package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.dao.ParticipantDao;
import se331.lab.entity.Participants;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantDao participantDao;

    @Override
    public Integer getParticipantSize() {
        return participantDao.getParticipantSize();
    }

    @Override
    public List<Participants> getAllParticipants() {
        return participantDao.getParticipants(Pageable.unpaged()).getContent();
    }
    
    @Override
    public Page<Participants> getParticipants(Integer page, Integer pageSize) {
        return participantDao.getParticipants(PageRequest.of(page, pageSize));
    }

    @Override
    public Participants getParticipant(Long id) {
        return participantDao.getParticipant(id);
    }

    @Override
    public Participants save(Participants participant) {
        return participantDao.save(participant);
    }
}

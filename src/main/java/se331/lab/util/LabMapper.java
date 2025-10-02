package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.dto.EventDTO;
import se331.lab.dto.OrganizerDTO;
import se331.lab.dto.ParticipantDTO;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participants;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    
    EventDTO getEventDTO(Event event);
    
    List<EventDTO> getEventDTO(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);

    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
    
    ParticipantDTO getParticipantDTO(Participants participant);
    
    List<ParticipantDTO> getParticipantDTO(List<Participants> participants);
}

package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.dto.EventDTO;
import se331.lab.entity.Event;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    
    EventDTO getEventDTO(Event event);
    
     List<EventDTO> getEventDTO(List<Event> events);
}

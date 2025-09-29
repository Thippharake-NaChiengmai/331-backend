package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.dto.EventDTO;
import se331.lab.entity.Event;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    
    EventDTO getEventDTO(Event event);
    
    default List<EventDTO> getEventDTO(List<Event> events) {
        return events.stream()
                .map(this::getEventDTO)
                .collect(Collectors.toList());
    }

    default ResponseEntity<?> getEventDTO(List<Event> events, HttpHeaders headers, HttpStatus status) {
        return new ResponseEntity<>(getEventDTO(events), headers, status);
    }
}

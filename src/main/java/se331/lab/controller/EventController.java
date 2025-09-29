package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se331.lab.entity.Event;
import se331.lab.service.EventService;
import se331.lab.util.LabMapper;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class EventController {
    private final EventService eventService;

    @GetMapping("events")
    public ResponseEntity<?> getEvents(
            @RequestParam(value = "_limit", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "_page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "title", required = false) String title) {
        
        pageSize = pageSize == null ? 10 : pageSize;
        page = page == null ? 1 : page;
        
        Page<Event> pageOutput;
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        
        if (title != null && !title.trim().isEmpty()) {
            pageOutput = eventService.getEvents(title, pageRequest);
        } else {
            pageOutput = eventService.getAllEvents(pageRequest);
        }
        
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        
        return new ResponseEntity<>(
            LabMapper.INSTANCE.getEventDTO(pageOutput.getContent()),
            responseHeader, 
            HttpStatus.OK
        );
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = eventService.getEventId(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getEventDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
    
    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        Event output = eventService.save(event);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(output.getId())
                .toUri();
        return ResponseEntity.created(location).body(LabMapper.INSTANCE.getEventDTO(output));
    }
}


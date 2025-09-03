package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import se331.lab.entity.Event;
import se331.lab.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
    final EventService eventService;
    @GetMapping("event")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page) {
        List<Event> output = null;
        Integer eventSize = eventService.getEventSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(eventSize));
        try{
       output = eventService.getEvents(perPage, page);
        return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
    }catch (IndexOutOfBoundsException ex){
        }
        return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Integer id) {
        Event output = eventService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The given id is not found");
        }
    }
}


package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import se331.lab.entity.Participants;
import se331.lab.service.ParticipantService;
import se331.lab.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("participants")
    public ResponseEntity<?> getParticipants() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participantService.getAllParticipants()));
    }

    @GetMapping("participants/{id}")
    public ResponseEntity<?> getParticipant(@PathVariable("id") Long id) {
        Participants output = participantService.getParticipant(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The given id is not found");
        }
    }

    @PostMapping("/participants")
    public ResponseEntity<?> addParticipant(@RequestBody Participants participant) {
        Participants output = participantService.save(participant);
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(output));
    }
}

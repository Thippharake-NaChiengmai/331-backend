package se331.lab.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import se331.lab.security.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    List<OrganizerOwnEventsDTO> ownEvents = new ArrayList<>();

    List<String> images;
}

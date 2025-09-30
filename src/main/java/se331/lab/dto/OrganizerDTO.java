package se331.lab.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    List<OrganizerOwnEventsDTO> ownEvents = new ArrayList<>();
}

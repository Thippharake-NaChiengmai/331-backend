package se331.lab.dto;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventOrganizerDTO {
    Long id;
    String name;
}

package se331.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventHistoryDTO {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String location;
    private String date;
    private String time;
    private Boolean petAllowed;
    private OrganizerDTO organizer;
    private List<String> images;
}

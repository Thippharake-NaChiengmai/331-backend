package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .organization("Kat Laydee Foundation")
                .address("123 Cat Street, Meow Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .organization("Flora City Gardens")
                .address("456 Garden Ave, Flora City")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .organization("Ocean Conservation Group")
                .address("789 Beach Blvd, Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .organization("Woof Town Animal Shelter")
                .address("101 Dog Park Lane, Woof Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .organization("Tin City Food Bank")
                .address("202 Charity Rd, Tin City")
                .build());
        organizerList.add(Organizer.builder()
                .id(6L)
                .organization("Highway Clean Initiative")
                .address("303 Highway 50, Clean City")
                .build());
        organizerList.add(Organizer.builder()
                .id(7L)
                .organization("Cannabis Education Center")
                .address("404 Green Street, sansainoi, CNX")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Integer id) {
        return organizerList.stream()
                .filter(organizer -> organizer.getId().equals(Long.valueOf(id)))
                .findFirst()
                .orElse(null);
    }
}

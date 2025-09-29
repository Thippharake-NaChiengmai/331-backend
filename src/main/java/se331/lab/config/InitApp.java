package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
        final EventRepository eventRepository;
        final OrganizerRepository organizerRepository;

        @Override
        public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {

                eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Midterm Exam")
                                .description("A time for taking the exam")
                                .location("CAMT Building")
                                .date("3rd Sept")
                                .time("3.00-4.00 pm.")
                                .petAllowed(false)
                                .build());

                eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Commencement Day")
                                .description("A time for celebration")
                                .location("CMU Convention hall")
                                .date("21th Jan")
                                .time("8.00am-4.00 pm.")
                                .petAllowed(false)
                                .build());

                eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Loy Krathong")
                                .description("A time for Krathong")
                                .location("Ping River")
                                .date("21th Nov")
                                .time("8.00-10.00 pm.")
                                .petAllowed(false)
                                .build());

                eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Songkran")
                                .description("Let's Play Water")
                                .location("Chiang Mai Moat")
                                .date("13th April")
                                .time("10.00am - 6.00 pm.")
                                .petAllowed(true)
                                .build());

                eventRepository.save(Event.builder()
                                .category("Sleep")
                                .title("Sleeping")
                                .description("Sleeping in SE-331 Class")
                                .location("ILC-C208–C209")
                                .date("12th September")
                                .time("12.00am - 00.00 pm.")
                                .petAllowed(true)
                                .build());

                // Initialize Organizers
//                organizerRepository.save(Organizer.builder()
//                                .organization("CAMT")
//                                .address("CAMT Old Building")
//                                .build());
//
//                organizerRepository.save(Organizer.builder()
//                                .organization("CAMT")
//                                .address("CAMT New Building")
//                                .build());
//
//                organizerRepository.save(Organizer.builder()
//                                .organization("CMU")
//                                .address("Chiang Mai University")
//                                .build());
//
//                organizerRepository.save(Organizer.builder()
//                                .organization("Chiang Mai Municipality")
//                                .address("Chiang Mai City Hall")
//                                .build());
//
//                organizerRepository.save(Organizer.builder()
//                               .organization("CAMT")
//                               .address("Room ILC-C208–C209")
//                               .build());
        }
}

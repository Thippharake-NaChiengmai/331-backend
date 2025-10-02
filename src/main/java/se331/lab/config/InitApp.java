package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participants;

import java.util.List;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;
@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
        @Autowired
    EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

        @Override
         @Transactional
        public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {

            Organizer org1, org2, org3,org4;
            org1 = organizerRepository.save(Organizer.builder()
                    .name("CAMT").build());
            org2 = organizerRepository.save(Organizer.builder()
                    .name("CMU").build());
            org3 = organizerRepository.save(Organizer.builder()
                    .name("ChaingMai").build());
            org4 = organizerRepository.save(Organizer.builder()
                    .name("LIC Building, CAMT").build());

            Participants participant1, participant2, participant3, participant4, participant5;
            
            participant1 = participantRepository.save(Participants.builder()
                    .name("John Doe")
                    .TelNo("0812345678")
                    .eventHistory(new java.util.ArrayList<>())
                    .build());
            
            participant2 = participantRepository.save(Participants.builder()
                    .name("Jane Smith")
                    .TelNo("0823456789")
                    .eventHistory(new java.util.ArrayList<>())
                    .build());
            
            participant3 = participantRepository.save(Participants.builder()
                    .name("Bob Johnson")
                    .TelNo("0834567890")
                    .eventHistory(new java.util.ArrayList<>())
                    .build());
            
            participant4 = participantRepository.save(Participants.builder()
                    .name("Alice Brown")
                    .TelNo("0845678901")
                    .eventHistory(new java.util.ArrayList<>())
                    .build());
            
            participant5 = participantRepository.save(Participants.builder()
                    .name("Charlie Wilson")
                    .TelNo("0856789012")
                    .eventHistory(new java.util.ArrayList<>())
                    .build());

            Event tempEvent;

            tempEvent = eventRepository.save(Event.builder()
                    .category("Academic")
                    .title("Midterm Exam")
                    .description("A time for taking the exam")
                    .location("CAMT Building")
                    .date("3rd Sept")
                    .time("3.00-4.00 pm.")
                    .petAllowed(false)
                    .build());
            tempEvent.setOrganizer(org1);
            tempEvent.setParticipants(List.of(participant1, participant2, participant3));
            participant1.getEventHistory().add(tempEvent);
            participant2.getEventHistory().add(tempEvent);
            participant3.getEventHistory().add(tempEvent);
            org1.getOwnEvents().add(tempEvent);

            tempEvent = eventRepository.save(Event.builder()
                    .category("Academic")
                    .title("Commencement Day")
                    .description("A time for celebration")
                    .location("CMU Convention hall")
                    .date("21th Jan")
                    .time("8.00am-4.00 pm.")
                    .petAllowed(false)
                    .build());
            tempEvent.setOrganizer(org1);
            tempEvent.setParticipants(List.of(participant2, participant3, participant4));
            participant2.getEventHistory().add(tempEvent);
            participant3.getEventHistory().add(tempEvent);
            participant4.getEventHistory().add(tempEvent);
            org1.getOwnEvents().add(tempEvent);

            tempEvent = eventRepository.save(Event.builder()
                    .category("Cultural")
                    .title("Loy Krathong")
                    .description("A time for Krathong")
                    .location("Ping River")
                    .date("21th Nov")
                    .time("8.00-10.00 pm.")
                    .petAllowed(false)
                    .build());
            tempEvent.setOrganizer(org2);
            tempEvent.setParticipants(List.of(participant3, participant4, participant5 ));
            participant3.getEventHistory().add(tempEvent);
            participant4.getEventHistory().add(tempEvent);
            participant5.getEventHistory().add(tempEvent);
            org2.getOwnEvents().add(tempEvent);

            tempEvent = eventRepository.save(Event.builder()
                    .category("Cultural")
                    .title("Songkran")
                    .description("Let's Play Water")
                    .location("Chiang Mai Moat")
                    .date("13th April")
                    .time("10.00am - 6.00 pm.")
                    .petAllowed(true)
                    .build());
            tempEvent.setOrganizer(org3);
            tempEvent.setParticipants(List.of(participant1, participant3, participant5));
            participant1.getEventHistory().add(tempEvent);
            participant3.getEventHistory().add(tempEvent);
            participant4.getEventHistory().add(tempEvent);
            org3.getOwnEvents().add(tempEvent);

            tempEvent = eventRepository.save(Event.builder()
                    .category("Sleep")
                    .title("Sleeping")
                    .description("Sleeping in SE-331 Class")
                    .location("ILC-C208–C209")
                    .date("12th September")
                    .time("12.00am - 00.00 pm.")
                    .petAllowed(true)
                    .build());
            tempEvent.setOrganizer(org4);
            tempEvent.setParticipants(List.of(participant2, participant4, participant1));
            participant2.getEventHistory().add(tempEvent);
            participant4.getEventHistory().add(tempEvent);
            participant1.getEventHistory().add(tempEvent);
            org4.getOwnEvents().add(tempEvent);
        
        }
}

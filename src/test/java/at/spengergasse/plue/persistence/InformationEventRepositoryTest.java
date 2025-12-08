package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.InformationEvent;
import at.spengergasse.plue.domain.InformationEventType;
import at.spengergasse.plue.domain.Room;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InformationEventRepositoryTest {

    @Autowired
    private InformationEventRepository informationEventRepository;

    @Test
    public void can_save() {
        var informationEvent = InformationEvent.builder()
                // eventType: muss aus irgendeinem grund null sein
                .eventType(InformationEventType.GUIDED_TOUR)
                .name("Test Information Event")
                .description("Test Information Event Description")
                .room(Room.builder()
                        .building("Test Building")
                        .level("Test Level")
                        .roomNo("Test RoomNo")
                        .description("Test Room Description")
                        .numberOfDesks(69)
                        .numberOfSeats(420)
                        .build()
                )
                .build();

        var saved = informationEventRepository.saveAndFlush(informationEvent);
        assertThat(saved.getId()).isNotNull();
    }
}

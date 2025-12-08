package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.InformationEvent;
import at.spengergasse.plue.domain.InformationEventType;
import at.spengergasse.plue.domain.Room;
import at.spengergasse.plue.dtos.InformationEventSummary;
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

    @Test
    public void can_find_all_summaries() {
        var informationEvent = InformationEvent.builder()
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

        informationEventRepository.saveAndFlush(informationEvent);

        var summaries = informationEventRepository.findAllSummary();

        assertThat(summaries).isNotEmpty();
        assertThat(summaries.getFirst()).extracting(InformationEventSummary::roomNo).isEqualTo(
                "%s.%s.%s".formatted(
                        informationEvent.getRoom().getBuilding(),
                        informationEvent.getRoom().getLevel(),
                        informationEvent.getRoom().getRoomNo()
                )
        );
    }
}

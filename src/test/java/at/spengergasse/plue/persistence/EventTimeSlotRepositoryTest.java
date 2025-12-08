package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.EventTimeSlot;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Time;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EventTimeSlotRepositoryTest {

    @Autowired
    private EventTimeSlotRepository eventTimeSlotRepository;

    @Test
    public void can_save() {
        var eventTimeSlot = EventTimeSlot.builder()
                .slotTitle("Test Event Slot")
                .slotDescription("Test Event Slot Description")
                .day(new Date())
                .from(new Time(1000 * 60 * 60 * 14))
                .to(new Time(1000 * 60 * 60 * 16))
                .build();

        var saved = eventTimeSlotRepository.saveAndFlush(eventTimeSlot);
        assertThat(saved.getId()).isNotNull();
    }
}

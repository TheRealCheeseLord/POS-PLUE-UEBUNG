package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.InformationEvent;
import at.spengergasse.plue.dtos.InformationEventSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InformationEventRepository extends JpaRepository<InformationEvent, InformationEvent.InformationEventId> {

    @Query("SELECT new at.spengergasse.plue.dtos.InformationEventSummary(ie.eventType, ie.name, concat(ie.room.building, '.', ie.room.level, '.', ie.room.roomNo), ie.room.numberOfSeats ) FROM InformationEvent ie")
    List<InformationEventSummary> findAllSummary();

    List<InformationEvent> findAllByRoom_Level(String roomLevel);
}

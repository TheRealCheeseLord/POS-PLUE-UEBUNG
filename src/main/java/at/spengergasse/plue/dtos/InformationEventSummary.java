package at.spengergasse.plue.dtos;

import at.spengergasse.plue.domain.InformationEvent;
import at.spengergasse.plue.domain.InformationEventType;
import jakarta.validation.constraints.NotNull;

public record InformationEventSummary(
        InformationEventType eventType,
        String name,
        String roomNo,
        int numberOfSeats
) {
    public InformationEventSummary(@NotNull InformationEvent informationEvent) {
        this(
                informationEvent.getEventType(),
                informationEvent.getName(),
                "%s.%s.%s".formatted(
                        informationEvent.getRoom().getBuilding(),
                        informationEvent.getRoom().getLevel(),
                        informationEvent.getRoom().getRoomNo()
                ),
                informationEvent.getRoom().getNumberOfSeats()
        );
    }
}

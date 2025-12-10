package at.spengergasse.plue.dtos;

import at.spengergasse.plue.domain.InformationEvent;
import at.spengergasse.plue.domain.InformationEventType;
import jakarta.validation.constraints.NotNull;

public record InformationEventSummary(
        InformationEventType eventType,
        String name,
        String roomNo,
        int numberOfSeats
) {}

package at.spengergasse.plue.persistence.converter;

import at.spengergasse.plue.domain.InformationEventType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InformationEventTypeConverter implements AttributeConverter<InformationEventType, Character> {
    @Override
    public Character convertToDatabaseColumn(InformationEventType informationEventType) {
        return switch (informationEventType) {
            case GUIDED_TOUR -> 'G';
            case MAKER_SPACE -> 'M';
            case PRESENTATION -> 'P';
            case null -> null;
        };
    }

    @Override
    public InformationEventType convertToEntityAttribute(Character character) {
        return switch (character) {
            case 'G' -> InformationEventType.GUIDED_TOUR;
            case 'M' -> InformationEventType.MAKER_SPACE;
            case 'P' -> InformationEventType.PRESENTATION;
            case null ->  null;
            default -> throw new IllegalArgumentException("DQE: %s is not a valid character representation of InformationEventType".formatted(character));
        };
    }
}

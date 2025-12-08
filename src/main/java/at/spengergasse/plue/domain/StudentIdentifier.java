package at.spengergasse.plue.domain;

import java.util.regex.Pattern;

public record StudentIdentifier(String value) {
    public static final String VALIDATION_REGEX = "[A-Z]{3}[0-9]{5,6}";
    private static final Pattern PATTERN = Pattern.compile(VALIDATION_REGEX);

    public StudentIdentifier {
        if (value == null) throw new IllegalArgumentException();
        if (!PATTERN.matcher(value).matches()) throw new IllegalArgumentException("StudentIdentifier does not match valid pattern.");
    }
}

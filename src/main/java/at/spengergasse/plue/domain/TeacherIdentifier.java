package at.spengergasse.plue.domain;

import java.util.regex.Pattern;

public record TeacherIdentifier(String value) {
    public static final String VALIDATION_REGEX = "[A-Z]{2,3}";
    private static final Pattern PATTERN = Pattern.compile(VALIDATION_REGEX);

    public TeacherIdentifier {
        if (value == null) throw new IllegalArgumentException();
        if (!PATTERN.matcher(value).matches()) throw new IllegalArgumentException("TeacherIdentifier does not match valid pattern.");
    }
}

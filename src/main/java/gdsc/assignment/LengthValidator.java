package gdsc.assignment;

import java.util.stream.Stream;

public interface LengthValidator {
	AssignmentStatus validateWilLength(Stream<String> lines);
}

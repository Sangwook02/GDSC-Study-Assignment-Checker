package gdsc.assignment;

import java.util.stream.Stream;

public class Length300Validator implements LengthValidator {
	private static final int MINIMUM_LENGTH = 300;

	@Override
	public AssignmentStatus validateWilLength(Stream<String> lines) {
		long wilLength = lines.mapToLong(String::length).sum();

		if (wilLength >= MINIMUM_LENGTH) {
			return AssignmentStatus.DONE;
		}
		return AssignmentStatus.INSUFFICIENT;
	}
}

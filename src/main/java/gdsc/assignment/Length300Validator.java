package gdsc.assignment;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Length300Validator implements LengthValidator {
	private static final int MINIMUM_LENGTH = 300;

	@Override
	public AssignmentStatus validateWilLength(Stream<String> lines) {
		String collect = lines.collect(Collectors.joining());

		if (getWilLength(collect) >= MINIMUM_LENGTH) {
			return AssignmentStatus.DONE;
		}
		return AssignmentStatus.INSUFFICIENT;
	}
}

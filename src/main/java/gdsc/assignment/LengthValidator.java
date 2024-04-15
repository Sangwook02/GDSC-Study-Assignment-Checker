package gdsc.assignment;

import java.util.stream.Stream;

public interface LengthValidator {
	AssignmentStatus validateWilLength(Stream<String> lines);

	default int getWilLength(String content) {
		content = content.replaceAll("(http|https)://[^\\s]+", "");
		return content.length();
	}
}

package gdsc.assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AssignmentStatus {
	DONE("과제 완수"),
	INSUFFICIENT("불성실"),
	NOT_DONE("과제 미완수");

	private final String description;
}

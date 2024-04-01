package gdsc.assignment;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		AssignmentChecker assignmentChecker = AssignmentChecker.create();
		Result result = assignmentChecker.checkAssignment();
		result.printResult();
	}
}
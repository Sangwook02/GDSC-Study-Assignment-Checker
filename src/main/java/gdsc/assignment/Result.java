package gdsc.assignment;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Result {
	int totalSubmissions = 0;
	int totalStudents = 0;

	public void addTotalSubmissions() {
		totalSubmissions++;
	}

	public void addTotalStudents() {
		totalStudents++;
	}

	public void printResult() {
		System.out.println("totalSubmissions = " + totalSubmissions);
		System.out.println("totalStudents = " + totalStudents);
	}
}

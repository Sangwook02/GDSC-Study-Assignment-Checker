package gdsc.assignment;

import static gdsc.assignment.AssignmentStatus.*;
import static java.net.HttpURLConnection.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AssignmentChecker {
	private InputReader inputReader;
	private ResultGenerator resultGenerator;
	private LengthValidator lengthValidator;


	public static AssignmentChecker create() throws IOException {
		return new AssignmentChecker(InputReader.getInstance(), ResultGenerator.getInstance(), new Length300Validator());
	}

	public Result checkAssignment() throws IOException {
		Result result = ResultGenerator.create();
		List<String> submissionUrls = inputReader.getSubmissionUrls();

		submissionUrls.forEach(s -> {
			try {
				URL url = new URL(s);
				if (evaluateAssignment(url) == DONE) {
					resultGenerator.writeToFile(url.toString());
					result.addTotalSubmissions();
				}
				result.addTotalStudents();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		resultGenerator.close();
		return result;
	}

	private AssignmentStatus evaluateAssignment(URL url) throws IOException {
		HttpURLConnection connection = sendRequest(url);
		if (getResponseCode(connection) == HTTP_NOT_FOUND) {
			return NOT_DONE;
		}

		return validateWilLength(connection);
	}

	private AssignmentStatus validateWilLength(HttpURLConnection connection) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		Stream<String> lines = bufferedReader.lines();

		return lengthValidator.validateWilLength(lines);
	}

	private int getResponseCode(HttpURLConnection connection) throws IOException {
		return connection.getResponseCode();
	}

	private HttpURLConnection sendRequest(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		return connection;
	}
}

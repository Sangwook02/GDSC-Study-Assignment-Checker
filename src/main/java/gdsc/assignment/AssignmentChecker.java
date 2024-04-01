package gdsc.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AssignmentChecker {
	private InputReader inputReader;
	private ResultGenerator resultGenerator;


	public static AssignmentChecker create() throws IOException {
		return new AssignmentChecker(InputReader.getInstance(), ResultGenerator.getInstance());
	}

	public Result checkAssignment() throws IOException {
		Result result = ResultGenerator.create();
		List<String> submissionUrls = inputReader.getSubmissionUrls();

		submissionUrls.forEach(s -> {
			try {
				URL url = new URL(s);
				if (evaluateAssignment(url) == AssignmentStatus.DONE) {
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
		if (getResponseCode(url) == 200) {
			resultGenerator.writeToFile(url.toString());
			return AssignmentStatus.DONE;
		}
		return AssignmentStatus.NOT_DONE;
	}

	private int getResponseCode(URL url) throws IOException {
		HttpURLConnection connection = sendRequest(url);
		return connection.getResponseCode();
	}

	private HttpURLConnection sendRequest(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		return connection;
	}
}

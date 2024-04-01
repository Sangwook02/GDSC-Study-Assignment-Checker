package gdsc.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class InputReader {
	private final BufferedReader br;

	public static InputReader getInstance() throws IOException {
		return new InputReader();
	}

	private InputReader() throws IOException {
		File inputFile = new File(Config.getInstance().getInputFilePath());
		this.br = new BufferedReader(new FileReader(inputFile));
	}

	public List<String> getSubmissionUrls() throws IOException {
		String wil = Config.getInstance().getWil();
		return br.lines()
			.filter(Objects::nonNull)
			.map(githubHandle -> String.format(wil, githubHandle)).toList();
	}
}

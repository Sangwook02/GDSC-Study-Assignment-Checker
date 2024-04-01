package gdsc.assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultGenerator {
	private final BufferedWriter bw;

	public static ResultGenerator getInstance() throws IOException {
		return new ResultGenerator();
	}

	private ResultGenerator() throws IOException {
		File outputFile = new File(Config.getInstance().getOutputFilePath());
		this.bw = new BufferedWriter(new FileWriter(outputFile));
	}

	public static Result create() {
		return new Result();
	}

	public void writeToFile(String url) throws IOException {
		bw.write("- <" + url + "> \n");
	}

	public void close() throws IOException {
		bw.close();
	}
}

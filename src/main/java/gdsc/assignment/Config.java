package gdsc.assignment;

import java.io.IOException;
import java.util.Properties;

import lombok.Getter;

@Getter
public class Config {
	private String wilPrefix;
	private String wilPostfix;
	private String inputFilePath;
	private String outputFilePath;
	private String wil;
	private String studyName;
	private int week;
	private int numberOfWil;

	public static Config getInstance() throws IOException {
		return new Config();
	}

	private Config() throws IOException {
		getProperties();
	}

	private void getProperties() throws IOException {
		Properties properties = new Properties();
		properties.load(Main.class.getResourceAsStream("/application.properties"));

		wilPrefix = properties.getProperty("wilPrefix");
		wilPostfix = properties.getProperty("wilPostfix");
		inputFilePath = properties.getProperty("inputFilePath");
		outputFilePath = properties.getProperty("outputFilePath");
		studyName = properties.getProperty("studyName");
		week = Integer.parseInt(properties.getProperty("week"));
		numberOfWil = Integer.parseInt(properties.getProperty("numberOfWil"));
		wil = wilPrefix + makeWilPostFix();
	}

	private String makeWilPostFix() {
		return String.format(wilPostfix,studyName, week, numberOfWil);
	}

}

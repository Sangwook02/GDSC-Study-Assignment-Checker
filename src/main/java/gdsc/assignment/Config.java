package gdsc.assignment;

import java.io.IOException;
import java.util.Properties;

import lombok.Getter;

@Getter
public class Config {
	private String wilFormat;
	private String inputFilePath;
	private String outputFilePath;
	private String wil;
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

		wilFormat = properties.getProperty("wilFormat");
		inputFilePath = properties.getProperty("inputFilePath");
		outputFilePath = properties.getProperty("outputFilePath");
		week = Integer.parseInt(properties.getProperty("week"));
		numberOfWil = Integer.parseInt(properties.getProperty("numberOfWil"));
		wil = makeWilPath();
	}

	private String makeWilPath() {
		return String.format(wilFormat, week, numberOfWil);
	}

}

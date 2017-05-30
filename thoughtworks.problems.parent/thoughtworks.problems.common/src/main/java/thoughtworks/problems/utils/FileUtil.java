package thoughtworks.problems.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Utility class to read/write files
 * 
 * @author tbansal
 *
 */
public class FileUtil {

	public static Pair<List<String>, List<String>> getGraphMetaData(String path) throws IOException {

		List<String> data = Files.readAllLines(Paths.get(path));

		return new Pair<List<String>, List<String>>(data.subList(0, data.indexOf("")),
				data.subList(data.indexOf("") + 1, data.size() - 1));

	}

	public static void writeOutput(List<Object> output, String outputFile) throws IOException {
		Path path = Paths.get(outputFile);
		try {

			try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
					StandardOpenOption.CREATE)) {
				for (Object o : output) {
					writer.write(o == null ? "" : o.toString());
					writer.newLine();
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

}

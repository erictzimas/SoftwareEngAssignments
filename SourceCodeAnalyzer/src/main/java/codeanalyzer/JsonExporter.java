package codeanalyzer;

import java.util.Map;

public class JsonExporter implements Exporter {
	@Override
	public void writeFile(String outputType, Map<String, Integer> metrics, String filepath) {
			writeJson(metrics, filepath);
	}
	private void writeJson(Map<String, Integer> metrics, String filepath) {
		// Functionality not implemented yet
		// No need to implement it for the assignment
		System.out.println("Json printed.");
	}
}

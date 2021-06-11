package codeanalyzer;

import java.util.Map;

public interface Exporter {
	
	 public void writeFile(String outputType, Map<String, Integer> metrics, String filepath);
}

package src.main.java.codeanalyzer;

import java.util.Map;
/**
 * This interface is implemented by
 * CsvExporter and JsonExporter classes
 * @author erictzimas
 */
public interface Exporter {
	
	 public void writeFile(String outputType, Map<String, Integer> metrics, String filepath);
}

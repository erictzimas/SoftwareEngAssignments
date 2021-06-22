package src.main.java.codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * This class acts as a facade to hide the implementetion
 * of the metrics calculation from the Client.
 * @author erictzimas
 */
public class TableCreation {
	public Map<String, Integer> createTable(String sourceCodeAnalyzerType, String sourceFileLocation, String filepath) throws IOException{
	AnalyzerFactory analyzerfactory = new AnalyzerFactory();
	Analyzer analyzer = analyzerfactory.createAnalyzer(sourceCodeAnalyzerType, sourceFileLocation);
	int loc = analyzer.calculateLOC(filepath);
	int nom = analyzer.calculateNOM(filepath);
	int noc = analyzer.calculateNOC(filepath);
	
	Map<String, Integer> metrics = new HashMap<>();
	metrics.put("loc",loc);
	metrics.put("nom",nom);
	metrics.put("noc",noc);
	
	return metrics;
	}
}

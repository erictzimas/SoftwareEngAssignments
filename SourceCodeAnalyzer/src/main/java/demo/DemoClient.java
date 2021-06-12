package src.main.java.demo;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import src.main.java.codeanalyzer.*;

public class DemoClient {

	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";

		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

		TableCreation table = new TableCreation();
		Map<String, Integer> metrics = new HashMap<>();
		metrics = table.createTable(sourceCodeAnalyzerType, sourceFileLocation, filepath);
				
		ExporterFactory factory = new ExporterFactory();
		Exporter exporter = factory.createFileExporter(outputFileType);
		exporter.writeFile(outputFileType, metrics, outputFilePath);
		
	}

}

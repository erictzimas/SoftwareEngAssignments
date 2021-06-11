package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAnalyzer implements Analyzer {
    FileReaderInterface fileReader;
	
	public RegexAnalyzer(String fileReaderType) {
		FileReaderFactory flfactory = new FileReaderFactory();
		FileReaderInterface flint = flfactory.createFileReader(fileReaderType);
		this.fileReader = flint;
	}
	@Override
	public int calculateLOC(String filepath) throws IOException {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
	        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

	        int nonCodeLinesCounter = 0;
	        while (nonCodeLinesMatcher.find()) {
	        	nonCodeLinesCounter++;
	        }
			
	        int sourceFileLength = sourceCode.split("\n").length;
	        int loc =  sourceFileLength - nonCodeLinesCounter;
	        
			return loc;
	}
	@Override
	public int calculateNOM(String filepath) throws IOException {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	        Matcher methodSignatures = pattern.matcher(sourceCode);

	        int methodCounter = 0;
	        while (methodSignatures.find()) {
	        	methodCounter++;
	        }
			return methodCounter;
		} 
	@Override
	public int calculateNOC(String filepath) throws IOException {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
	        Matcher classSignatures = pattern.matcher(sourceCode);

	        int classCounter = 0;
	        while (classSignatures.find()) {
	        	classCounter++;
	        }
			return classCounter;
		}
}

package codeanalyzer;

import java.io.IOException;

public interface Analyzer {
	public int calculateLOC(String filepath) throws IOException;
	public int calculateNOM(String filepath) throws IOException;
	public int calculateNOC(String filepath) throws IOException;
}

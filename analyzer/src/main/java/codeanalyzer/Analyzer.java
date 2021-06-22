package src.main.java.codeanalyzer;

import java.io.IOException;
/** 
 * This interface contains the 3 methods used to calculate Lines of Code,
 * Number of methods and 
 * Number of classes
 * @author erictzimas
 */
public interface Analyzer {
	public int calculateLOC(String filepath) throws IOException;
	public int calculateNOM(String filepath) throws IOException;
	public int calculateNOC(String filepath) throws IOException;
}

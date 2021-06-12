package src.main.java.codeanalyzer;

public class AnalyzerFactory {
   public Analyzer createAnalyzer(String sourceCodeAnalyzerType, String sourceFileLocation) {
	   Analyzer analyzer;
		if(sourceCodeAnalyzerType.equals("regex")) {
			analyzer = new RegexAnalyzer(sourceFileLocation);
		} else if (sourceCodeAnalyzerType.equals("strcomp")) {
			analyzer = new StrCompAnalyzer(sourceFileLocation);
		} else {
			throw new IllegalArgumentException("Unknown type : " + sourceCodeAnalyzerType);
		}
		return analyzer;
   }
}

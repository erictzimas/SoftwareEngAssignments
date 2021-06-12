package src.main.java.codeanalyzer;

public class ExporterFactory {
     public Exporter createFileExporter(String outputFileType) {
 	    Exporter expo;
    	if (outputFileType.equals("csv")) {
 			expo = new CsvExporter();	
 		} else if (outputFileType.equals("json")) {
 			expo = new JsonExporter();
 		} else {
			throw new IllegalArgumentException("Unknown type : " + outputFileType);
		}
 		return expo;
     }
}

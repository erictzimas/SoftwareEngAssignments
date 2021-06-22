package src.main.java.codeanalyzer;
/**
 * This factory creates FileReader objects based on
 * the fileReaderType
 * @author erictzimas
 */
public class FileReaderFactory {
	public FileReaderInterface createFileReader(String fileReaderType) {
		FileReaderInterface fileReader;
		if (fileReaderType.equals("local")) {
		    fileReader = new LocalFileReader();
		} else if (fileReaderType.contentEquals("web")) {
			fileReader = new WebFileReader();
		} else {
			throw new IllegalArgumentException("Unknown type : " + fileReaderType);
		}
		return fileReader;
	}

}

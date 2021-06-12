package src.main.java.codeanalyzer;

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

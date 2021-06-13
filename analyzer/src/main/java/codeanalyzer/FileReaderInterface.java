package src.main.java.codeanalyzer;
/**
 * This interface is implemented by
 * WebFileReader and LocalFileReader classes
 * @author erictzimas
 */
import java.io.IOException;
import java.util.List;

public interface FileReaderInterface {
	public List<String> readFileIntoList(String filepath) throws IOException;
	public String readFileIntoString(String filepath) throws IOException;
}

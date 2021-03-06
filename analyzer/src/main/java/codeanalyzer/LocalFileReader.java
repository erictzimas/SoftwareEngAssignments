package src.main.java.codeanalyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads a java file from
 * a local directory
 * @author erictzimas
 */

public class LocalFileReader implements FileReaderInterface {
    
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		// read a locally stored file
			List<String> lines = new ArrayList<>();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		// read a file stored in the web
		}
	/** 
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file
	 * or null if the type is neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		// read a locally stored file
			StringBuilder sb = new StringBuilder();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			return sb.toString();
		// read a file stored in the web
        
		}
}

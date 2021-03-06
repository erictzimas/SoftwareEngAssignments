package src.main.java.codeanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 * This class reads a java file from
 * a web directory
 * @author erictzimas
 */
public class WebFileReader implements FileReaderInterface{
    /** 
	 * @param filepath the url of the file
	 * @return a List that contains the contents of the file 
	 * or null if the type is neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
			List<String> lines = new ArrayList<>();
	        URL url = new URL(filepath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	lines.add(line);
	        }
	        reader.close();
			return lines;
	}
	
	/** 
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file
	 * or null if the type is neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
			StringBuilder sb = new StringBuilder();
	        URL url = new URL(filepath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	sb.append(line + "\n");
	        }
	        reader.close();
			return sb.toString();
	}


}

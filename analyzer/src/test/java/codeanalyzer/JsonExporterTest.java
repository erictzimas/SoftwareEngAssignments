package codeanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import src.main.java.codeanalyzer.JsonExporter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doCallRealMethod;

public class JsonExporterTest {
	
	JsonExporter mex = new JsonExporter();
	
	
	
	@Test
	public void testWriteJson() {
		JsonExporter mockedExporter = mock(JsonExporter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).writeFile("json", metrics, outputFilepath);
		mockedExporter.writeFile("json", metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).writeFile("json", metrics, outputFilepath);
	}
	


}
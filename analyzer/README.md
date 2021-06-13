# Design Patterns Assignment
Starting class diagram

<img src="/analyzer/resources/Starting_class_diagram.png" alt="MarineGEO circle logo" style="height: 100px; width:100px;"/>

Result class diagram

<img src="/analyzer/resources/Result_class_diagram.png" alt="MarineGEO circle logo" style="height: 100px; width:100px;"/>

1. To refactor this code base , the factory design pattern and the facade pattern were used.
2. Benefits.
* Separation of concerns: The logic to instantiate classes is
separated.
* Flexibility: We can extend lower class hierarchy without affecting
higher classes.
* Provides a simple interface to a complex system
* De-couples the subsystem for clients and other
subsystems, thereby promoting subsystem
independence and portability
* Layers the subsystem
* Hides implementation details from Client
3. Classes Participating
* 3 factory design patterns implemented in SourceFileReader, SourceCodeAnalyzer and MetricsExporter, 1 facade pattern implemented in DemoClient (TableCreation.java) to hide the implementation of the Analyzer functions.
* 3 factories
  1. AnalyzerFactory.java
  2. ExporterFactory.java
  3. FileReaderFactory.java
 * 3 interfaces
      1. Analyzer.java
      2. Exporter.java
      3. FileReaderInterface.java
 * 1 Facade class
      1. TableCreation.java
 * 6 interface implementetion classes
     1. CsvExporter.java
     2. JsonExporter.java
     3. LocalFileReader.java
     4. RegexAnalyzer.java
     5. StrCompAnalyzer.java
     6. WebFileReader.java
 
2. Run the executable by executing
	java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
were args translate to: 	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
example : 
	java -jar './target/analyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar'  ./src/test/resources/TestClass.java regex local metrics_results csv
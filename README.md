# Grades Histogram
This repository serves as a basic demonstration of the build automation tools (i.e., Maven, Gradle) for the needs of the Software Eningineering in Practice (SEiP) course offered by the [Department of Management Science & Technology](https://www.dept.aueb.gr/en/dmst) of the Athens University of Economics and Business. 

The goal of this repository is to:
1) Get familiar with a Java library.
2) Use Maven to package your application and an external library
into a standalone executable.

## Project Structure
This repository consists of a parent Maven project and one sub-project (module).
 [gradeshistogram](gradeshistogram) - creates a histogram from a given .txt file

Execute the following command in the repository root directory in order to build all modules. 
```
mvn package
```
This command generates a seperate jar file in each module's corresponding target (```module/target```) directory.  

### gradeshistogram
This module,requires one runtime dependency which is packaged in the main jar (fat-jar). To create a fat-jar you need to use the ```maven-assembly-plugin``` plugin and also define the class that is the main entry point of the system (the class that contains the main method). 
```
<plugin>
				<artifactId>maven-assembly-plugin</artifactId>
				<configuration>
					<archive>
						<manifest>
							<mainClass>gr.dmst.HistogramGenerator</mainClass> 
						</manifest>
					</archive>
					<descriptorRefs>
						<descriptorRef>jar-with-dependencies</descriptorRef>
					</descriptorRefs>
				</configuration>
				<executions>
					<execution>
						<id>make-assembly</id>
						<phase>package</phase>
						<goals>
							<goal>single</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
```

The produced jar is located in the target directory and can be executed as following:
```
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
Note that the gradeshistogram-0.0.1-SNAPSHOT.jar is not executable. 

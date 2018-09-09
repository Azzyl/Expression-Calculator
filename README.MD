### Expression Calculator
This project calculates the value of expression <br>
Accpeted operators: <, >, =, +, -, * <br>
Language: Kotlin <br>
Build tool: Gradle
#### Run the project
Open command line in the root of the project <br>
Type in the command line <br>
`gradle clean build` <br>
Put `in.txt` file with test samples into the `build/libs` folder,
go the the `build/libs` folder and run the project by executing jar file `java -jar calculator-fat-1.0-SNAPSHOT.jar`
<br>
The output is in the `out.txt` file in the same folder
#### Test the project
Type in the root of project `gradle test`
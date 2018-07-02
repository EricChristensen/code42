### Input module
To perform a run of the input analysis on the default file run the command
```
mvn exec:java -Dexec.mainClass="com.mycompany.app.input.Main" -pl Input
```
from the root directory of the project.

To specify an file other than the default file run the command
```
mvn exec:java -Dexec.mainClass="com.mycompany.app.input.Main" -Dexec.args="my_specific_file.txt" -pl Input
```
from the root directory of the project.

To add a new file to perform a run on, add it to the [resources folder](src/resources)
After this you can specify that file as an argument with the -Dexec.args="my_specific_file.txt" flag.

To run the tests that are written for this module, run
```
mvn clean test -pl Input
```
from the root directory.
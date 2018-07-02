### FileScanner module
This is the FileScanner module. To run the tests for the FileScanner, run
```
mvn clean test -pl FileScanner
```
from the root of the project folder.

To add more test cases, add the directory you want to scan in the [resources folder](src/resources) of this module
and follow the pattern set up in [the FileScannerTest](src/test/java/com/mycompany/app/filescanner/FileScannerTest.java)
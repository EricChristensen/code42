# Code42 Programming assignment submission
The following is my submission to the programming challenge that Code42 gave to me.
One of the requirements that occurs to me that I may have misunderstood initially:
```
no dependencies other than the jvm (a test framework such as JUnit or TestNG is acceptable)
```

As you can probably tell, this is a maven project. [Maven is a dependency management tool]("https://maven.apache.org/install.html") for java projects
so I didn't consider it to be a dependency like JUnit or an external third party like Guava to be.

However, the line "no dependencies other than the jvm" seems to consider the jvm a dependency which appears to
indicate that the dependencies are at a "machine level" and not a "project level" in which case, using maven
would violate the first requirement...

Well hopefully Code42 will still consider this submission, and perhaps I could do another assignment if need be.

## Project
The project consists of three modules, the Input module, the FileScanner module, and the FileScannerClient module.

First, please clone the repository and run clean install on the project
```
git clone https://github.com/EricChristensen/code42.git
cd code42
mvn clean install
```
This will run all of the test in the project as well, but we will go into more detail for each of the modules.

### [Input module]("./Input")
The Input module computes the programming challenge set forth that involves some calculating some statistics
and sorting some strings. For information on how to perform runs and add new files for run see the [Input module readme]("./Input/README.md")
 
### [FileScanner module]("./FileScanner")
The FileScanner module contains the code for the FileScanner class defined in the code sample 2 section
of the Code42 programming assignment. To see how to run and add tests for this class see thie [FileScanner readme]("./FileScanner/README.md")

### [FileScannerClient module]("./FileScannerClient")
This module is simply a module that consumes the file scanner class like any other project would. For details
see the [FileScannerClient module]("./FileScannerClient")

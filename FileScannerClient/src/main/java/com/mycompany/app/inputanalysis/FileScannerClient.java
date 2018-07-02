package com.mycompany.app.inputanalysis;

import com.mycompany.app.filescanner.FileScanner;
import java.io.File;
import java.net.URL;

/**
 * This class demonstrates that we can consume and use the publicly exposed functions from
 * FileScanner. This is in a separate maven module. If you go into the pom you will notice
 * that we include the FileScanner module as a dependency. Any project with access to the
 * FileScanner artifact can consume and use it like the FileScannerClient does.
 *
 * Note that this class is very similar to the Main class in the FileScanner module, but this
 * class is consuming the FileScanner as an artifact where as the Main class in the FileScanner module
 * is consuming it because it is in the same package.
 */
public class FileScannerClient {

  public static void main(String[] args) {
    FileScannerClient f = new FileScannerClient();
    f.run();
  }

  public void run() {
    FileScanner fileScanner = new FileScanner();
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource("directory0");

    File file = new File(url.getFile());
    FileScanner.ScanResult scanResult = fileScanner.scan(file);
    System.out.println(scanResult.getNumberOfDirectories());
    System.out.println(scanResult.getNumberOfFiles());
    System.out.println(scanResult.getTotalBytes());
    System.out.println(scanResult.getAverageBytes());

    url = classLoader.getResource("directory0/directory1");
    file = new File(url.getFile());
    FileScanner.ScanResult scanResult2 = fileScanner.scan(file);
    System.out.println(scanResult2.getNumberOfDirectories());
    System.out.println(scanResult2.getNumberOfFiles());
    System.out.println(scanResult2.getTotalBytes());
    System.out.println(scanResult2.getAverageBytes());
  }
}

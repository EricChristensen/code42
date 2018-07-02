package com.mycompany.app.filescanner;

import java.io.File;

/**
 * A runner class for the file scanner. Meant for debugging purposes on your local machine.
 * For test cases see the FileScannerTest.
 */
public class Main {
  public static void main(String[] args) throws Exception {
    FileScanner fileScanner = new FileScanner();
    File folder = new File(".");
    System.out.println("Scanning " + folder.getName());
    FileScanner.ScanResult scanResult = fileScanner.scan(folder);
    System.out.println("Number of files: " + scanResult.getNumberOfFiles());
    System.out.println("Number of directories: " + scanResult.getNumberOfDirectories());
    System.out.println("Number of bytes: " + scanResult.getTotalBytes());
    System.out.println("Average bytes per file: " + scanResult.getAverageBytes());
  }
}

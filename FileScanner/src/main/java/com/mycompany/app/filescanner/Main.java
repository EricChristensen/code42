package com.mycompany.app.filescanner;

import java.io.File;

/**
 * Created by ec035872 on 7/1/18.
 */
public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("Input a file: " + args);
    for (String arg : args) {
      System.out.println(arg);
    }

    FileScanner fileScanner = new FileScanner();
    File folder = new File("/Users/ec035872/Downloads");
    FileScanner.ScanResult scanResult = fileScanner.scan(folder);
    System.out.println("Number of files: " + scanResult.getNumberOfFiles());
    System.out.println("Number of directories: " + scanResult.getNumberOfDirectories());
    System.out.println("Number of bytes: " + scanResult.getTotalBytes());
    System.out.println("Average bytes per file: " + scanResult.getAverageBytes());

    //fileScanner.printAllFiles(folder);
  }
}

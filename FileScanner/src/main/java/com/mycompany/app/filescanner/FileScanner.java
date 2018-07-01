package com.mycompany.app.filescanner;

import java.io.File;

/**
 * Created by ec035872 on 7/1/18.
 */
public class FileScanner {

  public static int getOne() {
    return 1;
  }

  private int numberOfFiles = 0;
  private int numberOfDirectories = 0;
  private int totalBytes = 0;
  private int averageBytes = 0;

  static class ScanResult {
    private int numberOfFiles = 0;
    private int numberOfDirectories = 0;
    private long totalBytes = 0;
    private long averageBytes = 0;

    public int getNumberOfFiles() {
      return numberOfFiles;
    }

    public int getNumberOfDirectories() {
      return numberOfDirectories;
    }

    public long getTotalBytes() {
      return totalBytes;
    }

    public long getAverageBytes() {
      return averageBytes;
    }
  }

  public ScanResult scan(File folder) {
    ScanResult scanResult = new ScanResult();
    scanResult = compute(folder, scanResult);

    return scanResult;
  }

  public ScanResult compute(File folder, ScanResult scanResult) {
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
      if (file.isDirectory()) {
        numberOfDirectories += 1;
        compute(file, scanResult);
      } else {
        numberOfFiles += 1;
        totalBytes += file.length();
      }
    }
    if (numberOfFiles == 0) {
      averageBytes = 0;
    } else {
      averageBytes = totalBytes / numberOfFiles;
    }
    scanResult.averageBytes = averageBytes;
    scanResult.numberOfDirectories = numberOfDirectories;
    scanResult.numberOfFiles = numberOfFiles;
    scanResult.totalBytes = totalBytes;

    return scanResult;
  }

  public void printAllFiles(File folder) {


    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
      if (file.isDirectory()) {
        printAllFiles(file);
      } else {
        System.out.println(file.getName());
      }
    }
  }
}

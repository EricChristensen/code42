package com.mycompany.app.filescanner;

import java.io.File;

/**
 * This is a FileScanner.
 *
 * The only publicly exposed function is scan which returns a ScanResult class.
 */
public class FileScanner {

  private int numberOfFiles = 0;
  private int numberOfDirectories = 0;
  private int totalBytes = 0;
  private int averageBytes = 0;
  private boolean scanned = false;

  /**
   * The ScanResult class
   *
   * This class contains the following attributes as well as publicly exposed functions
   * to retreive these attributes:
   *
   * The numberOfFiles from a scan
   * The numberOfDirectories from a scan
   * The totalBytes of all of the files from a scan
   * The averageBytes of a file from a scan
   */
  public static class ScanResult {
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

  /**
   * This function performs a scan on the given folder.
   * It computes the values for a ScanResult object and then returns that object.
   *
   * @param folder: The directory/folder which the scan is to be performed on.
   * @return a ScanResult object
   */
  public ScanResult scan(File folder) {
    if (scanned == true) {
      reset();
      scanned = false;
    }

    compute(folder);

    ScanResult scanResult = new ScanResult();
    scanResult.averageBytes = averageBytes;
    scanResult.numberOfDirectories = numberOfDirectories;
    scanResult.numberOfFiles = numberOfFiles;
    scanResult.totalBytes = totalBytes;

    scanned = true;
    return scanResult;
  }

  /**
   * This is a recursive function that does most of the work calculating the values for the
   * ScanResult object. If the file given is a directory we will scan the contents of that directory
   * before scanning the rest of the files in the parent directory.
   *
   * @param folder: The file/folder/directory which the computation is performed on.
   */
  private void compute(File folder) {
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
      if (file.isDirectory()) {
        numberOfDirectories += 1;
        compute(file);
      } else {
        numberOfFiles += 1;
        totalBytes += file.length();
      }
    }
    // If the number of files is 0, we need to write some code to avoid a division by 0 from occuring
    if (numberOfFiles == 0) {
      averageBytes = 0;
    } else {
      averageBytes = totalBytes / numberOfFiles;
    }
  }

  /**
   * We need to reset the member variables used to store the ScanResult values back to zero
   * otherwise if we try to scan again out results will be wrong.
   */
  private void reset() {
    averageBytes = 0;
    numberOfDirectories = 0;
    numberOfFiles = 0;
    totalBytes = 0;
  }

}

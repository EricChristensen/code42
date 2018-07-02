package com.mycompany.app.filescanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the FileScanner class.
 *
 * The following test cases are provided for:
 *
 * A directory with multiple files and multiple sub directories.
 * A directory with a single file and no sub directories.
 * A directory with two files and no sub directories.
 * A directory with only an empty file.
 */
public class FileScannerTest {

  @Test
  public void firstTest() {
    assertEquals(2, 1+1);
  }

  File directory0;
  File directory1;
  File directory2;
  File emptyDirectory;
  FileScanner fileScanner;

  @Before
  public void init() {
    fileScanner = new FileScanner();
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource("directory0");
    directory0 = new File(url.getFile());
    url = classLoader.getResource("directory0/directory1");
    directory1 = new File(url.getFile());
    url = classLoader.getResource("directory0/directory2");
    directory2 = new File(url.getFile());
    url = classLoader.getResource("emptyDirectory");
    emptyDirectory = new File(url.getFile());
  }

  @Test
  public void testDirectory0() {
    FileScanner.ScanResult scanResult = fileScanner.scan(directory0);
    assertEquals(2, scanResult.getNumberOfDirectories());
    assertEquals(5, scanResult.getNumberOfFiles());
    assertTrue(scanResult.getTotalBytes() > 0);
    assertTrue(scanResult.getAverageBytes() > 0);
  }

  @Test
  public void testDirectory1() {
    FileScanner.ScanResult scanResult = fileScanner.scan(directory1);
    assertEquals(0, scanResult.getNumberOfDirectories());
    assertEquals(1, scanResult.getNumberOfFiles());
    assertTrue(scanResult.getTotalBytes() > 0);
    assertTrue(scanResult.getAverageBytes() > 0);
  }

  @Test
  public void testDirectory2() {
    FileScanner.ScanResult scanResult = fileScanner.scan(directory2);
    assertEquals(0, scanResult.getNumberOfDirectories());
    assertEquals(2, scanResult.getNumberOfFiles());
    assertTrue(scanResult.getTotalBytes() > 0);
    assertTrue(scanResult.getAverageBytes() > 0);
  }

  @Test
  public void testEmptyDirectory() {
    FileScanner.ScanResult scanResult = fileScanner.scan(emptyDirectory);
    assertEquals(0, scanResult.getNumberOfDirectories());
    assertEquals(1, scanResult.getNumberOfFiles());
    assertTrue(scanResult.getTotalBytes() == 0);
    assertTrue(scanResult.getAverageBytes() == 0);
  }
}

package com.mycompany.app.filescanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;


public class FileScannerTest {

  @Test
  public void firstTest() {
    assertEquals(2, 1+1);
  }

  @Test
  public void isOne() {
    Assert.assertEquals(1, FileScanner.getOne());
  }
}

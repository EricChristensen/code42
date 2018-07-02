package com.mycompany.app.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class InputAnalyzerTest {

  private InputAnalyzer inputAnalyzer;

  @Before
  public void init() {
    try {
      inputAnalyzer = new InputAnalyzer("test2.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Initialization Failed");
      fail();
    }
  }

  @Test
  public void testGoodFile() {
    boolean thrown = false;
    try {
      InputAnalyzer inputAnalyzer = new InputAnalyzer("test.txt");
    } catch (FileNotFoundException e) {
      thrown = true;
    }
    assertFalse(thrown);
  }

  @Test
  public void testBadFile() throws FileNotFoundException {
    boolean thrown = false;
    try {
      InputAnalyzer inputAnalyzer = new InputAnalyzer("file that doesnt exist");
    } catch (FileNotFoundException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void testAverage() {
    assertEquals(2.0, inputAnalyzer.average(), 0.0);
  }

  @Test
  public void testMedian() {
    assertEquals(2.0, inputAnalyzer.median(), 0.0);
  }

  @Test
  public void testSum() {
    assertEquals(6.0, inputAnalyzer.getTotal(), 0.0);
  }

  @Test
  public void testPercentage() {
    assertEquals((3.0 / 13.0) * 100.00, inputAnalyzer.getPercentageNumbers(), 0.0);
  }

  @Test
  public void testFirstElement() {
    assertEquals("zzzzzzzz", inputAnalyzer.getFirstStringElement());
  }

  @Test
  public void testLastElement() {
    assertEquals("a", inputAnalyzer.getLastStringElement());
  }

  @Test
  public void testContains() {
    assertTrue(inputAnalyzer.contains("a"));
    assertFalse(inputAnalyzer.contains("garbledy gook, i am not in the file hopefully"));
  }
}

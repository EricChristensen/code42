package com.mycompany.app.input;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;


public class ObTest  {


  private Ob ob;

  @Before
  public void init() {
    try {
      ob = new Ob("test2.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Initialization Failed");
      fail();
    }
  }

  @Test
  public void testGoodFile() {
    boolean thrown = false;
    try {
      Ob ob = new Ob("test.txt");
    } catch (FileNotFoundException e) {
      thrown = true;
    }
    assertFalse(thrown);
  }

  @Test
  public void testBadFile() throws FileNotFoundException {
    boolean thrown = false;
    try {
      Ob ob = new Ob("file that doesnt exist");
    } catch (FileNotFoundException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void testAverage() {
    assertEquals(2.0, ob.average(), 0.0);
  }

  @Test
  public void testMedian() {
    assertEquals(2.0, ob.median(), 0.0);
  }

  @Test
  public void testSum() {
    assertEquals(6.0, ob.getTotal(), 0.0);
  }

  @Test
  public void testPercentage() {
    assertEquals((3.0 / 13.0) * 100.00, ob.getPercentageNumbers(), 0.0);
  }

  @Test
  public void testFirstElement() {
    assertEquals("zzzzzzzz", ob.getFirstStringElement());
  }

  @Test
  public void testLastElement() {
    assertEquals("a", ob.getLastStringElement());
  }

  @Test
  public void testContains() {
    assertTrue(ob.contains("a"));
    assertFalse(ob.contains("garbledy gook, i am not in the file hopefully"));
  }
}

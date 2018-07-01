package com.mycompany.app.inputanalysis;

/**
 * This class does a few things. When you run it it:
 * Takes in a file
 * .
 * .
 * .
 */
public class Main {

  public static void main(String[] args) throws Exception {
    System.out.println("Input a file: " + args);
    for (String arg : args) {
      System.out.println(arg);
    }

    Ob ob = new Ob("test.txt");
    ob.printData();
  }
}



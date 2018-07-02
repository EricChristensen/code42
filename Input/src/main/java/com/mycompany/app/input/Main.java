package com.mycompany.app.input;

/**
 * This class runs the input analysis on a file located in the resources directory.
 * To run this on a different test file, add your file to the resources directory and then
 * change the string in the Ob constructor to the name of your file.
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

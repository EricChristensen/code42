package com.mycompany.app.input;

/**
 * This class runs the input analysis on a file located in the resources directory.
 * To run this on a different test file, add your file to the resources directory and then
 * change the string in the Ob constructor to the name of your file.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      Ob ob = new Ob("test.txt");
      ob.printData();
    } else if (args.length == 1) {
      Ob ob = new Ob(args[0]);
      ob.printData();
    } else {
      System.out.println("Failed due to wrong number of args. Specify a test file or no args for the default run.");
    }
  }
}

package com.mycompany.app.input;

/**
 * Created by ec035872 on 7/1/18.
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

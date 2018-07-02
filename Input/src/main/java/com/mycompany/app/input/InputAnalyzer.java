package com.mycompany.app.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * The InputAnalyzer class is a class that takes in a file and then performs some computation on the file.
 *
 * The file should consist of only strings and numbers.
 * For the numbers the mean, median, sum, and percentage of numbers to total contents of the file
 * should be computed.
 * For the strings the strings should be sorted into reverse alphabetical order and then
 * printed to standard output with the number of times that string occured in the file.
 */
public class InputAnalyzer {

  private List<Double> numbers;
  private TreeMap<String, Integer> stringsCounts;
  private DecimalFormat decimalFormat = new DecimalFormat("##.00");
  private double totalElements = 0;

  public InputAnalyzer(String path) throws FileNotFoundException {
    numbers = new ArrayList<>();
    stringsCounts = new TreeMap<>(new MyComparator());

    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource(path);
    if (url == null) {
      throw new FileNotFoundException();
    }
    File file = new File(url.getFile());

    try {

      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        if (isNumber(line)) {
          numbers.add(Double.parseDouble(line));
        } else {
          if (!stringsCounts.containsKey(line)) {
            stringsCounts.put(line, 1);
          } else {
            Integer newValue = stringsCounts.get(line) + 1;
            stringsCounts.put(line, newValue);
          }
        }
        totalElements += 1;
      }
      numbers.sort(Comparator.naturalOrder());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * A function that prints the data computed by the constructor and functions
   * to standard output.
   */
  public void printData() {
    System.out.println("Sum of all the numbers: " + decimalFormat.format(getTotal()));
    System.out.println("Average of all the numbers (mean): " + decimalFormat.format(average()));
    System.out.println("Median of all the numbers is: " + decimalFormat.format(median()));
    System.out.println("percentage of numbers: " + decimalFormat.format(getPercentageNumbers()));
    System.out.println("\nStrings: ");

    for (String string : stringsCounts.keySet()) {
      System.out.println(string + " " + stringsCounts.get(string));
    }
  }

  /**
   * Computes the sum of all of the numbers in the file.
   *
   * @return the sum computed.
   */
  public double getTotal() {
    double sum = 0;
    for (Double number : numbers) {
      sum += number;
    }
    return sum;
  }

  /**
   * Computes that mean of all of the numbers in the file.
   *
   * @return the mean computed.
   */
  public double average() {
    return getTotal() / numbers.size();
  }

  /**
   * Computes the median of all of the numbers in the file.
   *
   * @return the median computed.
   */
  public double median() {
    if (numbers.size() % 2 == 0) { // even
      return (numbers.get(numbers.size() / 2)) + (numbers.get(numbers.size() / 2 - 1));
    } else { // odd
      return numbers.get((int) Math.floor(numbers.size() / 2.0));
    }
  }

  /**
   * Returns the count of numbers given in the file.
   *
   * @return the count of the numbers.
   */
  int getCountOfNumbers() {
    return numbers.size();
  }

  /**
   * Computes the percentage of numbers compared to all lines in the file.
   *
   * @return the percentage of numbers computed.
   */
  double getPercentageNumbers() {
    return (getCountOfNumbers() / totalElements) * 100.00;
  }

  /**
   * Determines if a given string is present in the file.
   * @param string: the string to check for presence in the map.
   * @return true if the string is present, false if the string is not present.
   */
  public boolean contains(String string) {
    return stringsCounts.containsKey(string);
  }

  /**
   * Returns the first element in the map of strings.
   * This is mainly for testing purposes to make sure that the order of strings is correct.
   *
   * @return The first element in the map of strings.
   */
  public String getFirstStringElement() {
    return stringsCounts.firstKey();
  }

  /**
   * Returns the last element in the map of strings.
   * This is mainly for testing purposes to make sure that the order of strings is correct.
   *
   * @return The last element in the map of strings.
   */
  public String getLastStringElement() {
    return stringsCounts.lastKey();
  }

  /**
   * Determines whether the given number is a number.
   *
   * @param string: the string to check for use as a number.
   * @return true if the string can be used as a number, otherwise return false.
   */
  public boolean isNumber(String string) {
    boolean isNumber = false;
    try {
      Double.parseDouble(string);
      isNumber = true;
    } catch (NumberFormatException e) {

    }
    return isNumber;
  }

  /**
   * This is MyComparator
   *
   * The default behavior for the TreeMap comparator is to sort alphabetically.
   * A new comparator is not necessary for reverse alphabetical but
   * the default behavior when it comes to upper and lowercase is to sort it like:
   * a, b, c, d, ... x, y, z, A, B, C, ... X, Y, Z
   *
   * Case can be ignored by initializing the TreeMap with `String.CASE_INSENSITIVE_ORDER`
   * but this marks elements with the same characters but different cases for some of the characters
   * as duplicates.
   *
   * For example the strings "Eric" and "eRIC" would be identified as the same string and the result
   * of the count unique elements operation would be: Eric 2
   *
   * This doesn't look good to me which is why we have MyComparator here.
   * I think the result Eric 1, eRIC 1 looks nicer and the requirements did not specify cases.
   */
  public class MyComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      if (s2.toLowerCase().compareTo(s1.toLowerCase()) == 0) {
        return s2.compareTo(s1);
      } else {
        return s2.toLowerCase().compareTo(s1.toLowerCase());
      }
    }
  }
}

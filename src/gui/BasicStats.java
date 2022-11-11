package gui;

import java.util.*;

/**
 * A simple class to compute basic, descriptive statistics.
 */
public class BasicStats {

  public static void main(String... args) {
    System.out.println("Let's do some basic statistics...");
  }

  /**
   * Compute the mean of an array of numbers.
   */
  public static double mean(double... numbers) {
    double sum = 0;
    if (numbers.length == 0) {
      return sum;
    } else {
      for (double num : numbers) {
        sum += num;
      }
      return sum / numbers.length;
    }
  }

  /**
   * Compute the max of an array of numbers.
   */
  public static double max(double... numbers) {
    if (numbers.length < 1) {
      throw new ArrayIndexOutOfBoundsException("The array of numbers must not be empty.");
    } 
    else 
    {
      double max = -0.0;
      for (int counter = 0; counter < numbers.length; counter++) {
        if (numbers[counter] > max) {
          max = numbers[counter];
        }
      }
      return max;
    }
  }

  /**
   * Compute the median of an array of numbers.
   */
  public static double median(double... numbers) {
    Arrays.sort(numbers);

    int size = numbers.length;
    double median = 0.0;

    if (size > 0) {
      if (size % 2 == 0) {
        median = (numbers[size >> 1] + numbers[(size >> 1) - 1]) / 2;
      } else {
        median = numbers[size >> 1];
      }
    }

    return median;
  }

  /**
   * Compute the mode of an array of numbers.
   */
  public static double mode(double... numbers) {
    double mode = 0.0;
    int modeCount = 0;

    for (double num : numbers) {

      int count = 0;

      for (double otherNum : numbers) {
        if (num == otherNum) {
          count++;
        }
      }

      if (count > modeCount) {
        modeCount = count;
        mode = num;
      }

    }

    return mode;
  }
}

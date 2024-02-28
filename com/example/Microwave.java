package com.example;

import java.util.Scanner;

/**
 * Microwave time calculator
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 28-2-2024
 */

// HelloWorldStyle class
public final class Microwave {

  /** Private constructor to prevent instantiation. */
  private Microwave() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {

    Scanner sc = new Scanner(System.in);

    // Array of microwavable items
    final String[] microwaveItems = {"Sub", "Pizza", "Soup"};

    // Displays microwavable items as a list
    System.out.println("~Food~");
    for (int i = 0; i < microwaveItems.length; i++) {
      System.out.println((i + 1) + ". " + microwaveItems[i]);
    }

    System.out.print("Choose the number of the item you want");
    System.out.print(" to microwave: ");

    // Tries to cast the user's food choice and quantity to integers
    try {
      // Gets the user's food item choice
      final int userFood = sc.nextInt() - 1;
      // Gets the number of food items to microwave
      System.out.print("Enter the number of " + microwaveItems[userFood]);
      System.out.print("s you want to microwave (1-3): ");
      final int userQuantity = sc.nextInt();

      // Initializes total time in seconds to 0
      float totalSeconds = 0;

      // Only executes if user entered a quantity
      if (userQuantity >= 1 && userQuantity <= 3) {
        // Switch statement to add correct number of seconds depending on item
        switch (microwaveItems[userFood]) {
          case "Sub":
            totalSeconds += 60;
            break;

          case "Pizza":
            totalSeconds += 45;
            break;

          default:
            totalSeconds += 105;
            break;
        }

        // Gets total time by multiplying total seconds by quantity modifier
        switch (userQuantity) {
          case 1:
            break;
          case 2:
            totalSeconds *= 1.5;
            break;
          default:
            totalSeconds *= 2;
            break;
        }

        // Gets the number of minutes and seconds
        final int minutes = (int) Math.floor(totalSeconds / 60);
        final int seconds = (int) totalSeconds - (minutes * 60);

        // Displays the time it takes to microwave item of quantity
        System.out.print("It will take " + minutes + " minute and " + seconds);
        System.out.print(" seconds to microwave " + userQuantity + " ");
        System.out.println(microwaveItems[userFood] + "(s).");
      } else {
        // Tells the user to enter a valid quantity
        System.out.println("Can only microwave 1, 2, or 3 items at a time!");
      }

      // Tells the user to enter numeric input
    } catch (Exception e) {
      System.out.println("You must only enter listed values!");
    }
  }
}

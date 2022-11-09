package com.animalmanagement.view;

import java.util.Scanner;

import com.animalmanagement.util.constant.Constants;
import com.animalmanagement.util.Validator;

// This class is used to get inputs from the user and sends to validator class for validation.
// If the user input will be valid then it will be returned to the call or it will ask for new values.
public class UserInput {
    /**
     * Gets string as user input and passed to other method to check whether the string is valid or not.
     *
     * @param message - Contains user message.
     * @return return string if the string matches the pattern otherwise it will call itself with new message to print.
     */
    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String string = scanner.nextLine();
        if(Validator.isValidString(string)) {
            return string;
        }
        else {
            return getString(Constants.INVALID_INPUT);
        }
    }

    /**
     * Gets decimal values for the user and sends to validator to check.
     * If user input is valid then it sends it back to the caller to assign it to the variable.
     *
     * @param message - This parameter is used to display message to the user about the input.
     * @return float point value of string variable.
     */
    public static float getFloat(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String string = scanner.nextLine();
        if(Validator.isValidFloat(string)) {
            return Float.parseFloat(string);
        }
        else {
            return getFloat(Constants.INVALID_INPUT);
        }
    }

    /**
     * Gets integer values from the user and passing to the check.
     * If the given input of the user will be valid then it will return that value.
     * If given user will be invalid it will prompt the user about wrong input.
     *
     * @param message  To print the message about the user input
     * @return integer value of "value".
     */
    public static  int getInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String value;
        value = scanner.nextLine();
        if(Validator.isInt(value)) {
            return Integer.parseInt(value);
        }
        else {
            return getInt("Invalid Input");
        }
    }

    /**
     * Gets alpha numeric values from the user and returns back.
     *
     * @param message to prompt the user about the input.
     * @return string
     */
    public static String getAlphaNumericString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Gets character as an input from the user and returns to assign to the variable.
     *
     * @param message. It contains message to the user about the input.
     * @return choice  It scans a single character and returns back.
     */
    public static char getChar(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        char choice = scanner.nextLine().charAt(0);
        if(choice == Constants.YES || choice == Constants.NO) {
            return choice;
        }
        else {
            return getChar(Constants.INVALID_INPUT);
        }
    }
}
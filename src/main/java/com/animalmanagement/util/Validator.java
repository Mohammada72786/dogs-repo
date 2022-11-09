package com.animalmanagement.util;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

import com.animalmanagement.util.constant.Constants;


/**
 * validates all the user inputs
 */
public class Validator {

    /**
     * Checks whether the given input is in integer form or not.
     * @param value
     * @return true/false
     */
    public static boolean isInt(String value) {  
        try { 
            int temp = Integer.parseInt(value); 
            return true;
        }
        catch(NumberFormatException ex) {
            return false;
        }
    }  

    /**
     * It checks whether the input is in numeric form or not.
     * @param value
     * @return true/false
     */
   public static boolean isNumeric(String value) {
        try {
            float f = Float.parseFloat(value);
            return true;
        }
        catch(NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Gets decimal numbers from the user.
     *
     * @param value. It contains the numeric value the needs to check.
     * @return true/false True if a given input is a valid float else it will return false.
     */
    public static boolean isValidFloat(String value) {
        float f;   
        try {
            f = Float.parseFloat(value);
            return true;
        }
        catch(NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Checks whether the input matches given pattern or not.
     *
     * @param value it contains a string to check the validation.
     * @return true/false
     */
    public static boolean isValidString(String value) {
    return Pattern.matches("^([A-Z]{1})([a-zA-Z?( )]{2,50})$", value);
    }
    
    /**
     * Gets date related entries from the user and checks whether the format is valid or not.
     *
     * @param date
     * @return returns true if date is valid otherwise it returns false.
     */
  /*  public static boolean isValidDate(String date) throws DateTimeParseException {
        LocalDate birthDate = LocalDate.parse(date);
        LocalDate currentDate = LocalDate.now();
        return (birthDate.compareTo(currentDate) < 0 );
    }*/

    /**
     * It is used to check the validation of a date, if date is valid it will return that date.
     * If the given date will not be in correct format it will return a message to the user.
     *
     * @param dateOfBirth.  It is date of birth of an animal.
     * @return dateOfBirth. it returns date of birth of an animal back if the given date of birth is valid.
     */

    public static String validateDate(String dateOfBirth) {
        String date[] = dateOfBirth.split("-");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if (1 == month || 3 == month || 5 == month || 7 == month  
            || 8 == month || 10 == month || 12 == month) {
            if (0 < day && 31 >= day) {
                return dateOfBirth;
            }
        } else if (2 == month) {
            if (0 == year % 4) {
                if (0 == year % 100) {
                    if(0 == year % 400) {
                        if (0 < day && 29 >= day) {
                            return dateOfBirth;
                        }
                    }
                }
            }
        } else if (2 == month ) {
            if(0 == year % 4) {
                if(0 == year % 100) {
                    if(0< day && 28>= day) { 
                        return dateOfBirth;
                    }
                }
            }
        } else if (4 == month || 6 == month || 9 == month || 11 == month) {
            if (0 < day && 30 >= day) {
                return dateOfBirth;
            }
        }
        return "Invalid date, Make sure that you have entered a valid date";  
    }
  

    public static Date getDate(String value) throws ParseException {
    	Date date = null;
    	try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = simpleDateFormat.parse(value);
    	} catch(DateTimeException exception) {
    		PetLogger.error(exception.toString());	
    	}
        return date;
    }
}
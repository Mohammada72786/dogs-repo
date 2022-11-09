package com.animalmanagement.util;
import java.util.Date;

import com.animalmanagement.util.exception.InvalidAnimalAgeException;

public class DateUtil {

    /**
     * This method is used to calculate age of an animal.
     * 
     * @param dateOfBirth - It is used to carry date of birth of an animal on which it calculates age.
     * @return age. it returns age in number of years to its caller.
     * @throws invalidAgeException.
     */
    public static int calculateAge(Date dateOfBirth)  { 
        Date currentDate = new Date(); 
        long ageInMiliSecond = currentDate.getTime() - dateOfBirth.getTime();
        int age = (int)(ageInMiliSecond / (1000l * 60 * 60 * 24 * 365));
        return age;
    }
    public static java.sql.Date convertUtilDateToSql(Date dateOfBirth) {
        return new java.sql.Date(dateOfBirth.getTime());
    }

    public static Date convertSqlDateToUtil(Date dateOfBirth) { 
    return new java.util.Date(dateOfBirth.getTime());
    }
}
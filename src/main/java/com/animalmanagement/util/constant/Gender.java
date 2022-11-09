package com.animalmanagement.util.constant;

/**
 * This class is used to define the valid number of gender.
 *
 */
public enum Gender {
    MALE(1),
    FEMALE(2);
    private final int value;

    /**
     * private constructor.
     */
    private Gender(final int value) {
        this.value = value;
    }

    /**
     * This method is used to return.
     * @param Value It in input value given by the end user to select a gender among the given genders.
     * @return It returns Male or Female if the given value is valid otherwise it returns null.  
     */
    public static Gender getGender(int value) {
        Gender result = null;
        for (Gender gender : Gender.values()) {
            if(gender.value == value) {
                result = gender;
                break;
            }
        }
         return result;
    }
}
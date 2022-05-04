package service;

import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidInputException;
import exception.InvalidPhoneNumberException;
import util.DateConverter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class InputValidator {

    public static void nameCheck(String name) {
        if (name.length() < 10 || name.length() > 50) {
            throw new InvalidFullNameException("Invalid Full Name");
        }
    }

    public static void phoneNumberCheck(String phoneNumber) {
        String[] pn = {"090", "098", "091", "031", "035", "038"};
        if (!(phoneNumber.length() == 10
                && Arrays.asList(pn).contains(phoneNumber.substring(0,3)))) {
            throw new InvalidPhoneNumberException("Invalid Phone Number");
        }
    }

    public static LocalDate dobCheck(String dobStr) {
        LocalDate dob = null;
        try {
            dob = DateConverter.stringToDate(dobStr);
        } catch (DateTimeParseException e) {
            throw new InvalidDOBException("Invalid DoB");
        }
        return dob;
    }

    public static void numberOfRecruitmentCheck(int n) {
        if (n < 11 || n > 15) {
            throw new InvalidInputException("Invalid Input");
        }
    }
}

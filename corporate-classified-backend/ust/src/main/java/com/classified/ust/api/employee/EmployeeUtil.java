package com.classified.ust.api.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeUtil {

   /* public static boolean validateEmail(String employeeEmail) {
        String regex = "^([A-Za-z0-9.-_]+)@([a-z]+)\\.([a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeeEmail);
        if(matcher.matches())
            return true;
        else
            return false;
    }*/

    public static boolean validatePassword(String employeePassword) {
        String regex = "^(?=.+[A-Za-z]{3,})(?=.+[0-9]{3,})(?=[!@#%&*.-_]).{7,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeePassword);
        //matcher.matches()?return true:return false;
        if(matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean validateAddress(String employeeAddress) {
        String regex = "^([A-Za-z0-9.-_]){0,50}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeeAddress);
        //matcher.matches()?return true:return false;
        if(matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean validateMobileNumber(String employeeMobileNumber) {
        String regex = "^([0-9]){10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeeMobileNumber);
        //matcher.matches()?return true:return false;
        if(matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean validateName(String employeeName) {
        String regex = "^([A-Za-z]{5,})(\\s)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeeName);
        //matcher.matches()?return true:return false;
        if(matcher.matches())
            return true;
        else
            return false;
    }
}

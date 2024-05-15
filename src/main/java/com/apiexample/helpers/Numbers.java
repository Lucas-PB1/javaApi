package com.apiexample.helpers;

public class Numbers {
    public static boolean isNumeric(String number){
        if (number == null) return false;
        number = number.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double convertToDouble(String number){
        if (number == null) return 0d;
        number = number.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1.0d;
    }
}

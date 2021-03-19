package com.mycompany.utilities;

public class Utilities {

    public static boolean getBoolValue(String s) {
        boolean b = true;
        if (s.toLowerCase().equals("no")) {
            b = false;
        }
        return b;
    }

    public static boolean validBool(String s) {
        boolean valid = false;
        if (s.toLowerCase().equals("no")) {
            valid = true;
        } else if (s.toLowerCase().equals("yes")) {
            valid = true;
        }

        return valid;
    }

    public static boolean validInt(String s, int min, int max) {
        boolean valid = false;        
        if (s.matches("-?\\d+")) {
            if (Integer.parseInt(s) >= min) {
                if (Integer.parseInt(s) <= max) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    
}
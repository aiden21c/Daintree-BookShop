package com.mycompany.utilities;

public class Utilities {

    // Accepts a string and returns what boolean value it should be mapped to
    public static boolean getBoolValue(String s) {
        boolean b = true;
        if (s.toLowerCase().equals("no")) {
            b = false;
        }
        return b;
    }

    // Accepts a string and verifies whether it can be mapped to a valid boolean value
    public static boolean validBool(String s) {
        boolean valid = false;
        if (s.toLowerCase().equals("no")) {
            valid = true;
        } else if (s.toLowerCase().equals("yes")) {
            valid = true;
        }

        return valid;
    }

    // Accepts a string a verifies whether it can be mapped to an integer within a given range
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
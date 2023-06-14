package com.platzi.javatesting.util;

public class StringUtil {
    public static String repeat(String str, int times){
        // validar prueba negativa
        if (times <0) throw new IllegalArgumentException("negative times not allowed");

        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
    public static boolean isEmpty(String str) {
        return str==null || str.trim().isEmpty();
    }
}

package com.platzi.javatesting.util;
// comprobar password
public class PasswordUtil {

    // definir numeracion
    public enum SecurityLevel{
        WEAK,MEDIUM,STRONG;
    }


    // medir seguridad del password
    public static SecurityLevel assessPassword(String password){
        if (password.length()<8){
            return SecurityLevel.WEAK;
        }

        // matches : función regular,[]-> rango de letras ([a-zA-Z]+) -> y, que se pueden repetir
        if(password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }
        // indicar que tenga numeros y letras
        if(password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }
        return SecurityLevel.STRONG;
    }
}

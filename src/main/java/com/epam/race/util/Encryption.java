package com.epam.race.util;
import java.util.Base64;

public final class Encryption {

    public static String encrypt(String inputString){
        return Base64.getEncoder().encodeToString(inputString.getBytes());
    }

    public static String decrypt(String inputString){
        return new String(Base64.getDecoder().decode(inputString));
    }
}

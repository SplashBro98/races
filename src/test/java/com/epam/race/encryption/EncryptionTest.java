package com.epam.race.encryption;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;


public class EncryptionTest {

    @Test
    public void checkEncrypt(){
        String test = "Qwerty007";
        String encrypted = Base64.getEncoder().encodeToString(test.getBytes());

        String decrypted = new String(Base64.getDecoder().decode(encrypted));


        Assert.assertEquals(decrypted, test);
    }


}

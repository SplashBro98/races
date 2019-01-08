package com.epam.race.encryption;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;


public class EncryptionTest {

    @Test
    public void checkEncrypt(){
        String test = "Va02908902";
        String encrypted = Base64.getEncoder().encodeToString(test.getBytes());

        System.out.println(encrypted);

        String decrypted = new String(Base64.getDecoder().decode(encrypted));

        Assert.assertEquals(decrypted, test);
    }


}

package com.epam.race.encryption;

import com.epam.race.util.encryption.Encryption;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EncryptionTest {

    @Test
    public void checkEncrypt(){
        String test = "96Emudes";
        String actual = Encryption.encrypt(test);
        System.out.println(actual);

        String expected = "RW5jcnlwdGlvbiBUZXN0";
        Assert.assertEquals(actual, expected);
    }


}

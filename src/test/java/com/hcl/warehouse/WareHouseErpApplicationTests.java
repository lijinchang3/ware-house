package com.hcl.warehouse;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WareHouseErpApplicationTests {
    @Autowired
    StringEncryptor jasyptStringEncryptor;
    @Test
    public void encrypt() {
        System.out.println("name: " + jasyptStringEncryptor.encrypt("root"));
        System.out.println("password: " + jasyptStringEncryptor.encrypt("123456"));
    }
    @Test
    public void decrypt() {
        System.out.println(1);
    }

}

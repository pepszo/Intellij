package com.school;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.school.services.Password;

class PasswordTest {

    @Test
    void test() {
        Password p = new Password("test");
        p.firstHash();
        System.out.print(p.getHash());
        fail("Not yet implemented");

    }

}

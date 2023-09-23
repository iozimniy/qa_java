package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametersTests {

    private final String sex;
    private final boolean hasMane;

    public LionParametersTests(String sex, boolean hasMane) throws Exception {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setSex() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testHasMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actualMane = lion.doesHaveMane();
        assertEquals(hasMane, actualMane);
    }
}

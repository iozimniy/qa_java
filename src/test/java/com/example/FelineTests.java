package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Spy
    Feline feline;

    Feline otherFeline = new Feline();

    @Test
    public void testEatMeatCallsGetFood() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> actualFood = List.of("Животные", "Птицы", "Рыба");
        List<String> expectedFood = otherFeline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testFamily() {
        String actualFamily = otherFeline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals("Все кошки относятся к семейсту Кошачьи!", expectedFamily,actualFamily);
    }

    @Test
    public void testKittens() {
        int actualKittens = otherFeline.getKittens();
        int expectedKittens = 1;
        assertEquals("У этой кошки не один котёнок!",expectedKittens, actualKittens);
    }

    @Test
    public void testSetKittens() {
        int kittens = 6;
        int actualKittens = otherFeline.getKittens(kittens);
        assertEquals("На выходе не столько котят, сколько на входе!", kittens, actualKittens);
    }


}

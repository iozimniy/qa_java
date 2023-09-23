package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Feline feline;

    @Test
    public void testSound() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Бегающее мясо", "Летающее мясо", "Плавающее мясо"));
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        List<String> expectedFood = List.of("Бегающее мясо", "Летающее мясо", "Плавающее мясо");
        assertEquals(expectedFood, actualFood);
    }
}
package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline;

    @Test
    public void testNoSex() {
//        try {
//            Lion lion = new Lion("Гермафродит", feline);
//            lion.doesHaveMane();
//        } catch (Exception e) {
//            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
//        }
        //        пропробуем по-другому
        assertThrows(Exception.class, () -> new Lion("Гермафродит", feline));
    }


    @Test
    public void testGetKittensCallsFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        int expectedKittens = 1;
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetFoodCallsFelineGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, actualFood);
    }
}

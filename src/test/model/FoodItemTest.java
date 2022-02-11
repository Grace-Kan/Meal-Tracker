package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit test for FoodItem
public class FoodItemTest {
    private FoodItem testFood;

    @BeforeEach
    void runBefore() {
        testFood = new FoodItem("bread", "breakfast", 0);
    }

    @Test
    void testConstructor() {
        assertEquals("bread", testFood.getFoodTitle());
        assertEquals("breakfast", testFood.getMealType());
        assertEquals(0, testFood.getServings());
    }

    @Test
    void testChangeServings() {
        testFood.changeServings(1);
        assertEquals(1, testFood.getServings());
        testFood.changeServings(0);
        assertEquals(1, testFood.getServings());
    }
}

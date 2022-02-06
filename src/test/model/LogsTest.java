package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogsTest {
    private Logs testLog;

    @BeforeEach
    void runBefore() {
        testLog = new Logs();
    }

    @Test
    void testConstructor(){
        assertEquals(0, testLog.getFriday().getDinner().size());
        assertEquals(0, testLog.getSaturday().getLunch().size());
    }

    @Test
    void testAddMealsByDay(){
        testLog.addMealsByDay("Monday", new FoodItem("Egg", "breakfast", 1));
        assertEquals(1, testLog.getMonday().getBreakfast().size());
        assertEquals("Egg", testLog.getMonday().getBreakfast().get(0).getMealTitle());

        testLog.addMealsByDay("Tuesday", new FoodItem("Burger", "dinner", 1));
        assertEquals(1, testLog.getTuesday().getDinner().size());
        assertEquals("Burger", testLog.getTuesday().getDinner().get(0).getMealTitle());

        testLog.addMealsByDay("Wednesday", new FoodItem("Cookies", "snacks", 2));
        assertEquals(1, testLog.getWednesday().getSnacks().size());
        assertEquals("Cookies", testLog.getWednesday().getSnacks().get(0).getMealTitle());

        testLog.addMealsByDay("Thursday", new FoodItem("Salad", "lunch", 1));
        assertEquals(1, testLog.getThursday().getLunch().size());
        assertEquals("Salad", testLog.getThursday().getLunch().get(0).getMealTitle());

        testLog.addMealsByDay("Friday", new FoodItem("Noodles", "lunch", 1));
        assertEquals(1, testLog.getFriday().getLunch().size());
        assertEquals("Noodles", testLog.getFriday().getLunch().get(0).getMealTitle());

        testLog.addMealsByDay("Saturday", new FoodItem("Burrito", "dinner", 2));
        assertEquals(1, testLog.getSaturday().getDinner().size());
        assertEquals("Burrito", testLog.getSaturday().getDinner().get(0).getMealTitle());

        testLog.addMealsByDay("Sunday", new FoodItem("Matcha Ice Cream", "snacks", 2));
        assertEquals(1, testLog.getSunday().getSnacks().size());
        assertEquals("Matcha Ice Cream", testLog.getSunday().getSnacks().get(0).getMealTitle());

    }

    @Test
    void testMealContains() {
        assertFalse(testLog.mealContains("Monday", "breakfast", "food"));
        testLog.addMealsByDay("Monday", new FoodItem("noodles", "dinner", 2));
        assertTrue(testLog.mealContains("Monday", "dinner", "noodles"));


    }

    @Test
    void testRemoveFood() {
        testLog.addMealsByDay("Monday", new FoodItem("noodles", "dinner", 2));
        testLog.addMealsByDay("Monday", new FoodItem("ramen", "dinner", 2));
        testLog.removeFood("Monday", "dinner", "ramen");
        assertEquals(1, testLog.getMealsByDay("Monday").getAllMealsByMealTypes("dinner").size());

    }


}

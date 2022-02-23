package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MealTrackerTest {
    private MealTracker testMealTracker;

    @BeforeEach
    void runBefore() {
        testMealTracker = new MealTracker("week1");
    }

    @Test
    void testConstructor() {
        assertEquals("week1", testMealTracker.getWeek());
        assertEquals(0, testMealTracker.getLogsByDayAndMealType("Monday", "breakfast").size());
    }

    @Test
    void testAddFoodToLog() {
        testMealTracker.addFoodToLogs("Monday", new FoodItem("food", "breakfast", 1));
        testMealTracker.addFoodToLogs("Monday", new FoodItem("bread", "breakfast", 2));

        assertEquals(2, testMealTracker.getLogsByDayAndMealType("Monday", "breakfast").size());
        assertEquals("food",
                testMealTracker.getLogsByDayAndMealType("Monday", "breakfast").get(0).getFoodTitle());
        assertEquals(1,
                testMealTracker.getLogsByDayAndMealType("Monday", "breakfast").get(0).getServings());
    }

    @Test
    void testGetLogsByDayAndMealTyp() {
        FoodItem test = new FoodItem("food", "lunch", 1);
        testMealTracker.addFoodToLogs("Friday", test);

        assertEquals(test, testMealTracker.getLogsByDayAndMealType("Friday", "lunch").get(0));
    }
}

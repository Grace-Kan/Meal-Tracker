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

    void testConstructor(){
        //TODO
    }

    @Test
    void testAddMealsByDay(){
        testLog.addMealsByDay("Monday", new FoodItem("Egg", "breakfast"));
        assertEquals(1, testLog.getMonday().getBreakfast().size());

        testLog.addMealsByDay("Tuesday", new FoodItem("Burger", "dinner"));
        assertEquals(1, testLog.getTuesday().getDinner().size());

        testLog.addMealsByDay("Wednesday", new FoodItem("Cookies", "snacks"));
        assertEquals(1, testLog.getWednesday().getSnacks().size());

        testLog.addMealsByDay("Thursday", new FoodItem("Salad", "lunch"));
        assertEquals(1, testLog.getThursday().getLunch().size());

        testLog.addMealsByDay("Friday", new FoodItem("Noodles", "lunch"));
        assertEquals(1, testLog.getFriday().getLunch().size());

        testLog.addMealsByDay("Saturday", new FoodItem("Burrito", "dinner"));
        assertEquals(1, testLog.getSaturday().getDinner().size());

        testLog.addMealsByDay("Sunday", new FoodItem("Matcha Ice Cream", "snacks"));
        assertEquals(1, testLog.getSunday().getSnacks().size());

    }


}

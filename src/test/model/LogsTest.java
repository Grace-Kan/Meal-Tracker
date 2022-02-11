package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit tests for Logs class
public class LogsTest {
    private Logs testLog;
    private FoodItem testMon;
    private FoodItem testTues;
    private FoodItem testWed;
    private FoodItem testThurs;
    private FoodItem testFri;
    private FoodItem testSat;
    private FoodItem testSun;

    @BeforeEach
    void runBefore() {
        testLog = new Logs();
        testMon = new FoodItem("Egg", "breakfast", 1);
        testTues = new FoodItem("Burger", "dinner", 1);
        testWed = new FoodItem("Cookies", "snacks", 2);
        testThurs = new FoodItem("Salad", "lunch", 2);
        testFri = new FoodItem("Noodles", "lunch", 1);
        testSat = new FoodItem("Burrito", "dinner", 2);
        testSun = new FoodItem("Matcha Ice Cream", "snacks", 2);
    }

    @Test
    void testConstructor(){
        assertEquals(0, testLog.getFriday().getDinner().size());
        assertEquals(0, testLog.getSaturday().getLunch().size());
    }

    @Test
    void testAddMealsByDay(){
        testLog.addMealsByDay("Monday", testMon);
        assertEquals(1, testLog.getMonday().getBreakfast().size());
        assertEquals("Egg", testLog.getMonday().getBreakfast().get(0).getFoodTitle());

        testLog.addMealsByDay("Tuesday", testTues);
        assertEquals(1, testLog.getTuesday().getDinner().size());
        assertEquals("Burger", testLog.getTuesday().getDinner().get(0).getFoodTitle());

        testLog.addMealsByDay("Wednesday", testWed);
        assertEquals(1, testLog.getWednesday().getSnacks().size());
        assertEquals("Cookies", testLog.getWednesday().getSnacks().get(0).getFoodTitle());

        testLog.addMealsByDay("Thursday", testThurs);
        assertEquals(1, testLog.getThursday().getLunch().size());
        assertEquals("Salad", testLog.getThursday().getLunch().get(0).getFoodTitle());

        testLog.addMealsByDay("Friday", testFri);
        assertEquals(1, testLog.getFriday().getLunch().size());
        assertEquals("Noodles", testLog.getFriday().getLunch().get(0).getFoodTitle());

        testLog.addMealsByDay("Saturday", testSat);
        assertEquals(1, testLog.getSaturday().getDinner().size());
        assertEquals("Burrito", testLog.getSaturday().getDinner().get(0).getFoodTitle());

        testLog.addMealsByDay("Sunday", testSun);
        assertEquals(1, testLog.getSunday().getSnacks().size());
        assertEquals("Matcha Ice Cream", testLog.getSunday().getSnacks().get(0).getFoodTitle());

    }

    @Test
    void testGetMealsByDay() {

        testLog.addMealsByDay("Monday", testMon);
        testLog.addMealsByDay("Tuesday", testTues);
        testLog.addMealsByDay("Wednesday", testWed);
        testLog.addMealsByDay("Thursday", testThurs);
        testLog.addMealsByDay("Friday", testFri);
        testLog.addMealsByDay("Saturday", testSat);
        testLog.addMealsByDay("Sunday", testSun);

        assertEquals(testMon, testLog.getMealsByDay("Monday").getBreakfast().get(0));
        assertEquals(testTues, testLog.getMealsByDay("Tuesday").getDinner().get(0));
        assertEquals(testWed, testLog.getMealsByDay("Wednesday").getSnacks().get(0));
        assertEquals(testThurs, testLog.getMealsByDay("Thursday").getLunch().get(0));
        assertEquals(testFri, testLog.getMealsByDay("Friday").getLunch().get(0));
        assertEquals(testSat, testLog.getMealsByDay("Saturday").getDinner().get(0));
        assertEquals(testSun, testLog.getMealsByDay("Sunday").getSnacks().get(0));
    }

    @Test
    void testMealContains() {
        assertFalse(testLog.mealContains("Monday", "snacks", "food"));
        testLog.addMealsByDay("Monday", testMon);
        assertTrue(testLog.mealContains("Monday", "breakfast", "Egg"));
        assertFalse(testLog.mealContains("Monday", "breakfast", "rice"));


    }

    @Test
    void testRemoveFood() {
        testLog.addMealsByDay("Monday", new FoodItem("noodles", "dinner", 2));
        testLog.addMealsByDay("Monday", new FoodItem("ramen", "dinner", 2));
        testLog.removeFood("Monday", "dinner", "ramen");
        assertEquals(1, testLog.getMealsByDay("Monday").getAllMealsByMealTypes("dinner").size());
        testLog.removeFood("Monday", "dinner", "hotpot");
        assertEquals(1, testLog.getMealsByDay("Monday").getAllMealsByMealTypes("dinner").size());

    }


}

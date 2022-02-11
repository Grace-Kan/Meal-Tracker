package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit tests for Meals
class MealsTest {
    private Meals testMeals;
    private FoodItem testBreakfast;
    private FoodItem testLunch;
    private FoodItem testDinner;
    private FoodItem testSnacks;

    @BeforeEach
    void runBefore(){
        testMeals = new Meals();
        testBreakfast = new FoodItem("food", "breakfast", 1);
        testLunch = new FoodItem("food", "lunch", 1);
        testDinner = new FoodItem("food", "dinner", 1);
        testSnacks = new FoodItem("food", "snacks", 1);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testMeals.getBreakfast().size());
        assertEquals(0, testMeals.getLunch().size());
        assertEquals(0, testMeals.getDinner().size());
        assertEquals(0, testMeals.getSnacks().size());
    }

    @Test
    void testGetAllMealsByMealType() {

        testMeals.addMealByMealTypes(testBreakfast);
        testMeals.addMealByMealTypes(testLunch);
        testMeals.addMealByMealTypes(testDinner);
        testMeals.addMealByMealTypes(testSnacks);

        assertEquals(testBreakfast, testMeals.getAllMealsByMealTypes("breakfast").get(0));
        assertEquals(testLunch, testMeals.getAllMealsByMealTypes("lunch").get(0));
        assertEquals(testDinner, testMeals.getAllMealsByMealTypes("dinner").get(0));
        assertEquals(testSnacks, testMeals.getAllMealsByMealTypes("snacks").get(0));
    }


    @Test
    void testAddBreakfast() {
        testMeals.addMealByMealTypes(testBreakfast);
        assertEquals(1, testMeals.getBreakfast().size());
        testMeals.addMealByMealTypes(testBreakfast);
        assertEquals(2, testMeals.getBreakfast().size());
    }

    @Test
    void testAddLunch() {
        testMeals.addMealByMealTypes(testLunch);
        assertEquals(1, testMeals.getLunch().size());
        testMeals.addMealByMealTypes(testLunch);
        assertEquals(2, testMeals.getLunch().size());
    }

    @Test
    void testAddDinner() {
        testMeals.addMealByMealTypes(testDinner);
        assertEquals(1, testMeals.getDinner().size());
        testMeals.addMealByMealTypes(testDinner);
        assertEquals(2, testMeals.getDinner().size());
    }

    @Test
    void testAddSnack() {
        testMeals.addMealByMealTypes(testSnacks);
        assertEquals(1, testMeals.getSnacks().size());
        testMeals.addMealByMealTypes(testSnacks);
        assertEquals(2, testMeals.getSnacks().size());
    }

    @Test
    void testAddServings() {
        testMeals.addMealByMealTypes(testBreakfast);
        testMeals.addServings("breakfast", "food", "3" );
        assertEquals(4, testMeals.getBreakfast().get(0).getServings());
        testMeals.addServings("breakfast", "yogurt", "1");
        assertEquals(4, testMeals.getBreakfast().get(0).getServings());
    }
}

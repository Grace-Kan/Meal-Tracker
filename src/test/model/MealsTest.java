package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealsTest {
    private Meals testMeals;

    @BeforeEach
    void runBefore(){
        testMeals = new Meals();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testMeals.getBreakfast().size());
        assertEquals(0, testMeals.getLunch().size());
        assertEquals(0, testMeals.getDinner().size());
        assertEquals(0, testMeals.getSnacks().size());
    }


    @Test
    void testAddBreakfast() {
        testMeals.addMealByMealTypes(new FoodItem("Pancake", "breakfast", 2));
        assertEquals(1, testMeals.getBreakfast().size());
        testMeals.addMealByMealTypes(new FoodItem("Toast", "breakfast", 2));
        assertEquals(2, testMeals.getBreakfast().size());
    }

    @Test
    void testAddLunch(){
        testMeals.addMealByMealTypes(new FoodItem("Ramen", "lunch", 1));
        assertEquals(1, testMeals.getLunch().size());
        testMeals.addMealByMealTypes(new FoodItem("Salad", "lunch", 1));
        assertEquals(2, testMeals.getLunch().size());
    }

    @Test
    void testAddDinner(){
        testMeals.addMealByMealTypes(new FoodItem("Steak", "dinner", 1.5));
        assertEquals(1, testMeals.getDinner().size());
        testMeals.addMealByMealTypes(new FoodItem("Brocoli", "dinner", 4));
        assertEquals(2, testMeals.getDinner().size());
    }

    @Test
    void testAddSnack(){
        testMeals.addMealByMealTypes(new FoodItem("apples", "snacks", 2));
        assertEquals(1, testMeals.getSnacks().size());
        testMeals.addMealByMealTypes(new FoodItem("Chocolate", "snacks", 0.5));
        assertEquals(2, testMeals.getSnacks().size());
    }

    @Test
    void testAddServings() {
        testMeals.addMealByMealTypes(new FoodItem("toast", "breakfast", 1));
        testMeals.addServings("breakfast", "toast", "3" );
        assertEquals(4, testMeals.getBreakfast().get(0).getServings());
    }
}

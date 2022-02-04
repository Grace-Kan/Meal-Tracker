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
        testMeals.addMealByMealTypes(new FoodItem("Pancake", "breakfast"));
        assertEquals(1, testMeals.getBreakfast().size());
        testMeals.addMealByMealTypes(new FoodItem("Toast", "breakfast"));
        assertEquals(2, testMeals.getBreakfast().size());
    }

    @Test
    void testAddLunch(){
        testMeals.addMealByMealTypes(new FoodItem("Ramen", "lunch"));
        assertEquals(1, testMeals.getLunch().size());
        testMeals.addMealByMealTypes(new FoodItem("Salad", "lunch"));
        assertEquals(2, testMeals.getLunch().size());
    }

    @Test
    void testAddDinner(){
        testMeals.addMealByMealTypes(new FoodItem("Steak", "dinner"));
        assertEquals(1, testMeals.getDinner().size());
        testMeals.addMealByMealTypes(new FoodItem("Brocoli", "dinner"));
        assertEquals(2, testMeals.getDinner().size());
    }

    @Test
    void testAddSnack(){
        testMeals.addMealByMealTypes(new FoodItem("apples", "snacks"));
        assertEquals(1, testMeals.getSnacks().size());
        testMeals.addMealByMealTypes(new FoodItem("Chocolate", "snacks"));
        assertEquals(2, testMeals.getSnacks().size());
    }
}
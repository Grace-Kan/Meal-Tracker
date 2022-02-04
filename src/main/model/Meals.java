package model;

import java.util.ArrayList;

// Represents the meals of the day, which consists of breakfast, lunch, dinner, and snacks
public class Meals {
    private ArrayList<FoodItem> breakfast;
    private ArrayList<FoodItem> lunch;
    private ArrayList<FoodItem> dinner;
    private ArrayList<FoodItem> snacks;

    //EFFECTS: constructs Meals with an empty list of food items for breakfast, lunch, dinner and snacks
    public Meals() {
        breakfast = new ArrayList();
        lunch = new ArrayList();
        dinner = new ArrayList();
        snacks = new ArrayList();
    }

    //REQUIRES: must give in "breakfast", "lunch", "dinner", or snacks"
    //EFFECTS: returns the list of food items for corresponding to the given meal type
    public ArrayList<FoodItem> getAllMealsByMealTypes(String mealType) {
        return null;
    }

    //REQUIRES: mealType must be of "breakfast", "lunch", "dinner", or "snacks"
    //MODIFIES: this
    //EFFECTS: adds given food to the corresponding meal type
    public void addMealByMealTypes(FoodItem foodItem) {}


    public ArrayList<FoodItem> getBreakfast() {
        return breakfast;
    }

    public ArrayList<FoodItem> getLunch() {
        return lunch;
    }

    public ArrayList<FoodItem> getDinner() {
        return dinner;
    }

    public ArrayList<FoodItem> getSnacks() {
        return snacks;
    }
}

package model;


import org.json.JSONArray;
import org.json.JSONObject;

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

    //REQUIRES: must give as "breakfast", "lunch", "dinner", or "snacks"
    //EFFECTS: returns the list of food items corresponding to the given meal type
    public ArrayList<FoodItem> getAllMealsByMealTypes(String mealType) {
        if (mealType.equals("breakfast")) {
            return breakfast;
        } else if (mealType.equals("lunch")) {
            return lunch;
        } else if (mealType.equals("dinner")) {
            return dinner;
        } else {
            return snacks;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds given food to the corresponding meal type
    public void addMealByMealTypes(FoodItem foodItem) {
        if (foodItem.getMealType().equals("breakfast")) {
            breakfast.add(foodItem);
        } else if (foodItem.getMealType().equals("lunch")) {
            lunch.add(foodItem);
        } else if (foodItem.getMealType().equals("dinner")) {
            dinner.add(foodItem);
        } else {
            snacks.add(foodItem);
        }
    }



    //REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks", and serving must be >= 0
    //MODIFIES: FoodItem
    //EFFECTS: looks for food item with given food title and adds given amount of serving to the food item's serving
    public void addServings(String mealType, String foodTitle, String serving) {
        for (FoodItem fi : getAllMealsByMealTypes(mealType)) {
            if (fi.getFoodTitle().equals(foodTitle)) {
                fi.changeServings(Double.parseDouble(serving));
            }
        }
    }

    // REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks"
    // EFFECTS: returns meal as a JSON object
    public JSONObject mealsToJson(String mealType) {
        JSONObject json = new JSONObject();
        json.put(mealType, mealToJson(mealType));

        return json;
    }

    // REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks"
    // EFFECTS: returns the food items in meal as a JSON array
    public JSONArray mealToJson(String mealType) {
        JSONArray jsonArray = new JSONArray();

        for (FoodItem fi : getAllMealsByMealTypes(mealType)) {
            jsonArray.put(fi.toJson());
        }
        return jsonArray;
    }


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

package model;

import org.json.JSONObject;

// Represents a FoodItem with a meal title, meal type and amount of servings
public class FoodItem {
    private String foodTitle;
    private String mealType;
    private double servings;

    //REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks", and servings must be >= 0
    //EFFECTS: constructs a food item with the given meal title, meal type and servings
    public FoodItem(String foodTitle, String mealType, double servings) {
        this.foodTitle = foodTitle;
        this.mealType = mealType;
        this.servings = servings;
    }


    //REQUIRES: servings must be >= 0
    //MODIFIES: this
    //EFFECTS: increases the amount of servings by the given amount of servings
    public void changeServings(double servings) {
        this.servings = this.servings + servings;
    }

    //EFFECTS: returns this as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("food name", foodTitle);
        json.put("servings", servings);
        return json;
    }


    public String getFoodTitle() {
        return foodTitle;
    }

    public String getMealType() {
        return mealType;
    }

    public double getServings() {
        return servings;
    }
}

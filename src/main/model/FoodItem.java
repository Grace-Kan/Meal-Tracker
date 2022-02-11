package model;

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

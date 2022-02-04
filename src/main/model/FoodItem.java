package model;

public class FoodItem {
    private String mealTitle;
    private String mealType;

    public FoodItem(String mealTitle, String mealType) {
        this.mealType = mealType;
        this.mealTitle = mealTitle;
    }

    public String getMealTitle() {
        return mealTitle;
    }

    public String getMealType() {
        return mealType;
    }
}

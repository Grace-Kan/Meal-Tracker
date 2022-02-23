package model;

import org.json.JSONObject;

import java.util.ArrayList;

//
public class MealTracker {
    private String week;
    private Logs log;

    // Constructs a meal tracker with the name of the given week and a new Log
    public MealTracker(String week) {
        this.week = week;
        log = new Logs();
    }

    // EFFECTS: returns this as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("week", this.week);
        json.put("logs", log.logsToJson());

        return json;
    }

    //MODIFIES: this
    //EFFECTS: adds given foodItem to logs
    public void addFoodToLogs(String day, FoodItem foodItem) {
        log.addMealsByDay(day, foodItem);
    }

    // EFFECTS: gets the list of food items by the day and meal type
    public ArrayList<FoodItem> getLogsByDayAndMealType(String day, String mealType) {
        return log.getMealsByDay(day).getAllMealsByMealTypes(mealType);
    }

    public String getWeek() {
        return this.week;
    }

    public Logs getLog() {
        return this.log;
    }
}

package model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

// Represents the logs throughout the days of the week from Monday to Sunday
public class Logs {
    private Meals monday;
    private Meals tuesday;
    private Meals wednesday;
    private Meals thursday;
    private Meals friday;
    private Meals saturday;
    private Meals sunday;

    // EFFECTS: constructs a log with new meals for every day of the week
    public Logs() {
        monday = new Meals();
        tuesday = new Meals();
        wednesday = new Meals();
        thursday = new Meals();
        friday = new Meals();
        saturday = new Meals();
        sunday = new Meals();

    }

    //REQUIRES: day must be either "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" or "Sunday"
    //MODIFIES: this and Meals
    //EFFECTS: adds food item to the meals of the given day
    public void addMealsByDay(String day, FoodItem food) {
        if (day.equals("Monday")) {
            monday.addMealByMealTypes(food);
        } else if (day.equals("Tuesday")) {
            tuesday.addMealByMealTypes(food);
        } else if (day.equals("Wednesday")) {
            wednesday.addMealByMealTypes(food);
        } else if (day.equals("Thursday")) {
            thursday.addMealByMealTypes(food);
        } else if (day.equals("Friday")) {
            friday.addMealByMealTypes(food);
        } else if (day.equals("Saturday")) {
            saturday.addMealByMealTypes(food);
        } else {
            sunday.addMealByMealTypes(food);
        }
    }


    //REQUIRES: day must be either "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" or "Sunday"
    //EFFECTS: returns the meals corresponding to the given day
    public Meals getMealsByDay(String day) {
        if (day.equals("Monday")) {
            return monday;
        } else if (day.equals("Tuesday")) {
            return tuesday;
        } else if (day.equals("Wednesday")) {
            return wednesday;
        } else if (day.equals("Thursday")) {
            return thursday;
        } else if (day.equals("Friday")) {
            return friday;
        } else if (day.equals("Saturday")) {
            return saturday;
        } else {
            return sunday;
        }
    }

    //REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks"
    //EFFECTS: returns true if given mealType of given day
    // contains the food item with title of the given foodItem, false otherwise
    public Boolean mealContains(String day, String mealType, String foodItem) {
        for (FoodItem fi : getMealsByDay(day).getAllMealsByMealTypes(mealType)) {
            if (fi.getFoodTitle().equals(foodItem)) {
                return true;
            }
        }
        return false;
    }

    //REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks"
    //MODIFIES: this and Meals
    //EFFECTS: removes the foodItem with the given foodTitle from the given mealType
    public void removeFood(String day, String mealType, String foodTitle) {
        FoodItem itemToRemove = null;
        for (FoodItem fi : getMealsByDay(day).getAllMealsByMealTypes(mealType)) {
            if (fi.getFoodTitle().equals(foodTitle)) {
                itemToRemove = fi;
            }
        }

        if (itemToRemove != null) {
            getMealsByDay(day).getAllMealsByMealTypes(mealType).remove(itemToRemove);
        }
    }

    // EFFECTS: returns this as a JSON object
    public JSONArray logsToJson() {
        JSONArray json = new JSONArray();
        json.put(dayToJson("Monday"));
        json.put(dayToJson("Tuesday"));
        json.put(dayToJson("Wednesday"));
        json.put(dayToJson("Thursday"));
        json.put(dayToJson("Friday"));
        json.put(dayToJson("Saturday"));
        json.put(dayToJson("Sunday"));

        return json;
    }

    public JSONObject dayToJson(String day) {
        JSONObject json = new JSONObject();
        json.put(day, logToJson(day));
        return json;
    }

    public JSONArray logToJson(String day) {
        JSONArray json = new JSONArray();
        json.put(getMealsByDay(day).mealsToJson("breakfast"));
        json.put(getMealsByDay(day).mealsToJson("lunch"));
        json.put(getMealsByDay(day).mealsToJson("dinner"));
        json.put(getMealsByDay(day).mealsToJson("snacks"));
        return json;
    }


    public Meals getMonday() {
        return monday;
    }

    public Meals getTuesday() {
        return tuesday;
    }

    public Meals getWednesday() {
        return wednesday;
    }

    public Meals getThursday() {
        return thursday;
    }

    public Meals getFriday() {
        return friday;
    }

    public Meals getSaturday() {
        return saturday;
    }

    public Meals getSunday() {
        return sunday;
    }

}

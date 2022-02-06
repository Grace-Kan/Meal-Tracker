package model;

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
    //MODIFIES: this
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
    //EFFECTS: returns true if given mealType contains the food item with title of the given foodItem, false otherwise
    public Boolean mealContains(String day, String mealType, String foodItem) {
        for (FoodItem fi : getMealsByDay(day).getAllMealsByMealTypes(mealType)) {
            if (fi.getMealTitle().equals(foodItem)) {
                return true;
            }
        }
        return false;
    }

    //REQUIRES: mealType must be "breakfast", "lunch", "dinner", or "snacks"
    //MODIFIES: this
    //EFFECTS: removes the foodItem with the given foodTitle from the given mealType
    public void removeFood(String day, String mealType, String foodTitle) {
        FoodItem itemToRemove = null;
        for (FoodItem fi : getMealsByDay(day).getAllMealsByMealTypes(mealType)) {
            if (fi.getMealTitle().equals(foodTitle)) {
                itemToRemove = fi;
            }
        }

        if (itemToRemove != null) {
            getMealsByDay(day).getAllMealsByMealTypes(mealType).remove(itemToRemove);
        }
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

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
        if (day == "Monday") {
            monday.addMealByMealTypes(food);
        } else if (day == "Tuesday") {
            tuesday.addMealByMealTypes(food);
        } else if (day == "Wednesday") {
            wednesday.addMealByMealTypes(food);
        } else if (day == "Thursday") {
            thursday.addMealByMealTypes(food);
        } else if (day == "Friday") {
            friday.addMealByMealTypes(food);
        } else if (day == "Saturday") {
            saturday.addMealByMealTypes(food);
        } else {
            sunday.addMealByMealTypes(food);
        }
    }


    //REQUIRES: day must be either "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" or "Sunday"
    //EFFECTS: returns the meals corresponding to the given day
    public Meals getMealsByDay(String day) {
        if (day == "Monday") {
            return monday;
        } else if (day == "Tuesday") {
            return tuesday;
        } else if (day == "Wednesday") {
            return wednesday;
        } else if (day == "Thursday") {
            return thursday;
        } else if (day == "Friday") {
            return friday;
        } else if (day == "Saturday") {
            return saturday;
        } else {
            return sunday;
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

package ui;

import model.FoodItem;
import model.Logs;
import model.Meals;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInteraction {
    Scanner sc;
    Logs log;
    String action;

    public ConsoleInteraction() {
        sc = new Scanner(System.in);
        log = new Logs();
        action = "";

        System.out.println("Welcome to Meal Tracker!");
        while (!action.equals("exit")) {
            System.out.println("What would you like to do? (Choose between: add meal, view meal or exit)");
            action = sc.nextLine();

            if (action.equals("add meal")) {
                addMeal();
            } else if (action.equals("view meal")) {
                viewMeals();
            } else if (action.equals("exit")) {
                System.out.println("Bye, thank you for using Meal Tracker!");
            } else {
                System.out.println("I didn't understand that, try again.");
            }
        }

    }

    private void viewMeals() {
        System.out.println("Which Day would you like to view?");
        String logDay = sc.nextLine();
        System.out.println("Which meal would you like to view?");
        String logMeal = sc.nextLine();
        if (log.getMealsByDay(logDay).getAllMealsByMealTypes(logMeal).size() == 0) {
            System.out.println("No food was logged");
        } else {
            System.out.println(convertToOneString(log.getMealsByDay(logDay).getAllMealsByMealTypes(logMeal)));
        }

    }

    private void addMeal() {
        System.out.println("Please enter the day you wish to log"
                + " (Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String mealTime = sc.nextLine();
        System.out.println("Please enter the meal type (breakfast, lunch, dinner, snacks)");
        String mealType = sc.nextLine();
        System.out.println("Please enter the food item you wish to add");
        String mealTitle = sc.nextLine();
        log.addMealsByDay(mealTime, new FoodItem(mealTitle, mealType));
        System.out.println("Success! Added " + mealTitle);
    }

    private String convertToOneString(ArrayList<FoodItem> foodItems) {
        String listOfFoods = "";
        for (FoodItem fi: foodItems) {
            listOfFoods = listOfFoods + fi.getMealTitle() + ",";
        }
        return listOfFoods;
    }
}

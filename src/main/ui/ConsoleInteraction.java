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
            System.out.println("What would you like to do? (Choose between: add meal, delete meal, view meal,"
                    + " edit servings or exit)");
            action = sc.nextLine();

            if (action.equals("add meal")) {
                addMeal();
            } else if (action.equals("view meal")) {
                viewMeals();
            } else if (action.equals("delete meal")) {
                deleteMeal();
            } else if (action.equals("exit")) {
                System.out.println("Bye, thank you for using Meal Tracker!");
            } else if (action.equals("edit servings")) {
                editServings();
            } else {
                System.out.println("I didn't understand that, try again.");
            }
        }

    }

    private void viewMeals() {
        System.out.println("Which Day would you like to view?");
        String logDay = sc.nextLine();
        System.out.println("Which meal would you like to view? (breakfast, lunch, dinner, snacks)");
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
        System.out.println("Please enter the servings");
        String mealServings = sc.nextLine();
        log.addMealsByDay(mealTime, new FoodItem(mealTitle, mealType, Double.parseDouble(mealServings)));
        System.out.println("Success! Added " + mealTitle);
    }

    private void deleteMeal() {
        System.out.println("Please enter the day you wish to edit "
                + "(Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String dayToEdit = sc.nextLine();
        System.out.println("Please enter the meal type you wish to edit (breakfast, lunch, dinner, snacks)");
        String mealToEdit = sc.nextLine();
        System.out.println("Please indicate the item you wish to delete");
        String foodToDelete = sc.nextLine();
        if (log.mealContains(dayToEdit, mealToEdit, foodToDelete) == true) {
            log.removeFood(dayToEdit, mealToEdit, foodToDelete);
            System.out.println("Success! " + foodToDelete + " was deleted");
        } else {
            System.out.println("Sorry, the food you entered could not be found");
        }
    }

    private void editServings() {
        System.out.println("Please enter the day you wish to edit "
                + "(Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String dayToEdit = sc.nextLine();
        System.out.println("Please enter the meal type you wish to edit (breakfast, lunch, dinner, snacks)");
        String mealToEdit = sc.nextLine();
        System.out.println("Please the food item you wish to edit the serving for");
        String foodToEdit = sc.nextLine();
        System.out.println("How many servings would you like to add?");
        String servingsToAdd = sc.nextLine();
        if (log.mealContains(dayToEdit, mealToEdit, foodToEdit) == true) {
            log.getMealsByDay(dayToEdit).addServings(mealToEdit, foodToEdit, servingsToAdd);
            System.out.println("Success! Servings were added");
        } else {
            System.out.println("Sorry, the food you entered could not be found. Please try again");
        }
    }

    private String convertToOneString(ArrayList<FoodItem> foodItems) {
        String listOfFoods = "";
        for (FoodItem fi: foodItems) {
            listOfFoods = listOfFoods + fi.getMealTitle() + " (" + Double.toString(fi.getServings()) + ")" + ",";
        }
        return listOfFoods;
    }
}

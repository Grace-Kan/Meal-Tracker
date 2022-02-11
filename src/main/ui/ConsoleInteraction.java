package ui;

import model.FoodItem;
import model.Logs;

import java.util.ArrayList;
import java.util.Scanner;

// Meal Tracker console application
public class ConsoleInteraction {
    Scanner sc;
    Logs log;
    String action;

    //EFFECTS: Constructs a ConsoleInteraction with a scanner, new Logs and an empty string as the action. Also
    //runs the meal tracker application
    public ConsoleInteraction() {
        sc = new Scanner(System.in);
        log = new Logs();
        action = "";
        runApplication();
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    // referenced from SimpleCalculatorStarterLecLab
    public void runApplication() {

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
            } else if (action.equals("edit servings")) {
                editServings();
            } else if (action.equals("exit")) {
                System.out.println("Bye, thank you for using Meal Tracker!");
            } else {
                System.out.println("I didn't understand that, try again.");
            }
        }

    }


    //EFFECTS: Displays the food items logged for the meal of the day user selects
    private void viewMeals() {
        System.out.println("Which Day would you like to view? "
                + "(Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String logDay = sc.nextLine();
        if (!checkValidDay(logDay)) {
            System.out.println("Sorry, I didn't understand that, try again");
        } else {
            System.out.println("Which meal would you like to view? (breakfast, lunch, dinner, snacks)");
            String logMeal = sc.nextLine();
            if (!checkValidMeal(logMeal)) {
                System.out.println("Sorry, I didn't understand that, try again");
            } else {
                if (log.getMealsByDay(logDay).getAllMealsByMealTypes(logMeal).size() == 0) {
                    System.out.println("No food was logged");
                } else {
                    System.out.println(convertToOneString(log.getMealsByDay(logDay).getAllMealsByMealTypes(logMeal)));
                }
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: processes user commands and adds food item entered by user to the day and meal entered
    private void addMeal() {
        System.out.println("Please enter the day you wish to log"
                + " (Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String mealTime = sc.nextLine();
        if (!checkValidDay(mealTime)) {
            System.out.println("Sorry, I didn't understand that, try again");
        }  else {
            System.out.println("Please enter the meal type (breakfast, lunch, dinner, snacks)");
            String mealType = sc.nextLine();
            if (!checkValidMeal(mealType)) {
                System.out.println("Sorry, I didn't understand that, try again");
            } else {
                System.out.println("Please enter the food item you wish to add");
                String mealTitle = sc.nextLine();
                System.out.println("Please enter the servings");
                String mealServings = sc.nextLine();
                log.addMealsByDay(mealTime, new FoodItem(mealTitle, mealType, Double.parseDouble(mealServings)));
                System.out.println("Success! Added " + mealTitle);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: processes user commands and deletes food item entered by user from the day and meal entered
    private void deleteMeal() {
        System.out.println("Please enter the day you wish to edit "
                + "(Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String dayToEdit = sc.nextLine();
        if (!checkValidDay(dayToEdit)) {
            System.out.println("Sorry, I didn't understand that, try again");
        } else {
            System.out.println("Please enter the meal type you wish to edit (breakfast, lunch, dinner, snacks)");
            String mealToEdit = sc.nextLine();
            if (!checkValidMeal(mealToEdit)) {
                System.out.println("Sorry, I didn't understand that, try again");
            } else {
                System.out.println("Please indicate the item you wish to delete");
                String foodToDelete = sc.nextLine();
                if (log.mealContains(dayToEdit, mealToEdit, foodToDelete)) {
                    log.removeFood(dayToEdit, mealToEdit, foodToDelete);
                    System.out.println("Success! " + foodToDelete + " was deleted");
                } else {
                    System.out.println("Sorry, the food you entered could not be found. Please try again");
                }
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: processes user commands and changes servings amount of entered food item from selected meal of a day
    private void editServings() {
        System.out.println("Please enter the day you wish to edit "
                + "(Monday, Tuesday, Wednesday,Thursday, Friday, Saturday, Sunday)");
        String dayToEdit = sc.nextLine();
        if (!checkValidDay(dayToEdit)) {
            System.out.println("Sorry, I didn't understand that, try again");
        } else {
            System.out.println("Please enter the meal type you wish to edit (breakfast, lunch, dinner, snacks)");
            String mealToEdit = sc.nextLine();
            if (!checkValidMeal(mealToEdit)) {
                System.out.println("Sorry, I didn't understand that, try again");
            } else {
                System.out.println("Please enter the food item you wish to edit the serving for");
                String foodToEdit = sc.nextLine();
                System.out.println("How many servings would you like to add?");
                String servingsToAdd = sc.nextLine();
                if (log.mealContains(dayToEdit, mealToEdit, foodToEdit)) {
                    log.getMealsByDay(dayToEdit).addServings(mealToEdit, foodToEdit, servingsToAdd);
                    System.out.println("Success! Servings were added");
                } else {
                    System.out.println("Sorry, the food you entered could not be found. Please try again");
                }
            }
        }
    }

    //EFFECTS: converts list of foodItems into a string
    private String convertToOneString(ArrayList<FoodItem> foodItems) {
        String listOfFoods = "";
        for (FoodItem fi : foodItems) {
            listOfFoods = listOfFoods + fi.getFoodTitle() + " (" + Double.toString(fi.getServings()) + ")" + ",";
        }
        return listOfFoods;
    }

    //EFFECTS: returns true if day is either "Monday", "Tuesday","Wednesday","Thursday","Friday", "Saturday", or
    // "Sunday", false otherwise
    private Boolean checkValidDay(String day) {
        if (day.equals("Monday")) {
            return true;
        } else if (day.equals("Tuesday")) {
            return true;
        } else if (day.equals("Wednesday")) {
            return true;
        } else if (day.equals("Thursday")) {
            return true;
        } else if (day.equals("Friday")) {
            return true;
        } else if (day.equals("Saturday")) {
            return true;
        } else if (day.equals("Sunday")) {
            return true;
        } else {
            return false;
        }

    }

    //EFFECTS: returns true if meal is either "breakfast","lunch", "dinner", or "snacks". Returns false otherwise
    private Boolean checkValidMeal(String meal) {
        if (meal.equals("breakfast")) {
            return true;
        } else if (meal.equals("lunch")) {
            return true;
        } else if (meal.equals("dinner")) {
            return true;
        } else if (meal.equals("snacks")) {
            return true;
        } else {
            return false;
        }
    }


}

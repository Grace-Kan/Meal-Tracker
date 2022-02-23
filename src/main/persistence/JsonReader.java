package persistence;

import model.FoodItem;
import model.MealTracker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads Logs from JSON data stored in file. Referenced from JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs a reader that reads from the given source file
    public JsonReader(String source) {
        this.source = source;
    }

    public MealTracker read() throws IOException {
        String data = readFile(source);
        JSONObject jsonObject = new JSONObject(data);
        return parseLogs(jsonObject);
    }

    // EFFECTS: reads and returns source file as a string
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // MODIFIES: log
    // EFFECTS: parses and reads logs from Json Object
    private MealTracker parseLogs(JSONObject jsonObject) {
        String week = jsonObject.getString("week");
        MealTracker log = new MealTracker(week);
        addMealsToDay(log, jsonObject.getJSONArray("logs"));
        return log;

    }

    // MODIFIES: log
    // EFFECTS: parses meals of the days from JSON Object and add them to corresponding logs
    private void addMealsToDay(MealTracker log, JSONArray jsonObject) {
        JSONObject jsonMon = jsonObject.getJSONObject(0);
        addMeals(log, jsonMon, "Monday");

        JSONObject jsonTues = jsonObject.getJSONObject(1);
        addMeals(log, jsonTues, "Tuesday");

        JSONObject jsonWed = jsonObject.getJSONObject(2);
        addMeals(log, jsonWed, "Wednesday");

        JSONObject jsonThurs = jsonObject.getJSONObject(3);
        addMeals(log, jsonThurs, "Thursday");

        JSONObject jsonFri = jsonObject.getJSONObject(4);
        addMeals(log, jsonFri, "Friday");

        JSONObject jsonSat = jsonObject.getJSONObject(5);
        addMeals(log, jsonSat, "Saturday");

        JSONObject jsonSun = jsonObject.getJSONObject(6);
        addMeals(log, jsonSun, "Sunday");
    }


    // MODIFIES: log
    // EFFECTS: parses the meals from JSON object and adds them to the corresponding meals
    private void addMeals(MealTracker log, JSONObject jsonObject, String day) {
        JSONArray allMeals = jsonObject.getJSONArray(day);

        JSONObject objectBreakfast = allMeals.getJSONObject(0);
        JSONArray jsonBreakfast = objectBreakfast.getJSONArray("breakfast");
        addFoods(log, jsonBreakfast, "breakfast", day);

        JSONObject objectLunch = allMeals.getJSONObject(1);
        JSONArray jsonLunch = objectLunch.getJSONArray("lunch");
        addFoods(log, jsonLunch, "lunch", day);

        JSONObject objectDinner = allMeals.getJSONObject(2);
        JSONArray jsonDinner = objectDinner.getJSONArray("dinner");
        addFoods(log, jsonDinner, "dinner", day);

        JSONObject objectSnacks = allMeals.getJSONObject(3);
        JSONArray jsonSnacks = objectSnacks.getJSONArray("snacks");
        addFoods(log, jsonSnacks, "snacks", day);
    }

    // MODIFIES: log
    // EFFECTS: parses the list of Food Items from JSON object and adds them to the corresponding meal and day
    private void addFoods(MealTracker log, JSONArray foods, String mealType, String day) {
        for (Object json : foods) {
            JSONObject nextFood = (JSONObject) json;
            addFood(log, nextFood, mealType, day);
        }
    }

    // MODIFIES: log
    // EFFECTS: parses the food item from JSON object and adds it to the corresponding meal and day
    private void addFood(MealTracker log, JSONObject jsonFood, String mealType, String day) {
        String foodName = jsonFood.getString("food name");
        Double servings = jsonFood.getDouble("servings");
        FoodItem food = new FoodItem(foodName, mealType, servings);
        log.addFoodToLogs(day, food);

    }

}

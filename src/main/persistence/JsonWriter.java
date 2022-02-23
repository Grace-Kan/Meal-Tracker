package persistence;

import model.MealTracker;
import org.json.JSONObject;

import java.io.*;

// Represents a writer that writes Logs to file in JSOn representation. Referenced from JsonSerializationDemo
public class JsonWriter {
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs a writer that writes to the destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: starts the writer and throws FileNotFoundException if destination file cannot be found
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: closes and stops the writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: converts logs from Meal tracker to a JSON representation to a file
    public void write(MealTracker log) {
        JSONObject json = log.toJson();
        saveToFile(json.toString(4));
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    public void saveToFile(String json) {
        writer.print(json);
    }




}

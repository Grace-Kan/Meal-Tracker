package ui;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import model.FoodItem;
import model.MealTracker;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tools.AddMealTool;
import ui.tools.DeleteFoodTool;
import ui.tools.EditServingsTool;
import ui.tools.ViewMealTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MealTrackerUI implements ActionListener {
    private static final String FILE_NAME = "./data/mealtracker.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private MealTracker mt;

    private JFrame frame;
    private JPanel panel;
    private JButton addMeal;
    private JButton deleteMeal;
    private JButton viewMeal;
    private JButton editServings;
    private JButton save;
    private JButton load;

    private AddMealTool addMealTool;



    public MealTrackerUI() {
        mt = new MealTracker("My Meal Tracker");
        jsonWriter = new JsonWriter(FILE_NAME);
        jsonReader = new JsonReader(FILE_NAME);
        frame = new JFrame();
        panel = new JPanel();
        initializeButtons();
        setPanel();
        setFrame();

        addMeal.addActionListener(this); //change addMealTool to this
        deleteMeal.addActionListener(this);
        viewMeal.addActionListener(this);
        editServings.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);


    }

    private void initializeButtons() {
        addMeal = new JButton("Add Meal");
        deleteMeal = new JButton("Delete Meal");
        viewMeal = new JButton("View Meals");
        editServings = new JButton("Edit Servings");
        save = new JButton("Save Log");
        load = new JButton("Load Previous Log");
    }

    private void setPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panel.setLayout(new GridLayout(3,2));
        panel.add(addMeal);
        panel.add(deleteMeal);
        panel.add(viewMeal);
        panel.add(editServings);
        panel.add(save);
        panel.add(load);

    }

    private void setFrame() {
        frame.setTitle("My Meal Tracker");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
    }

    private void saveLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(mt);
            jsonWriter.close();
            System.out.println("Log saved to" + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("The file you wish to save to does not exist");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads mt from file
    // referenced from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    private void loadLog() {
        try {
            mt = jsonReader.read();
            System.out.println("Loaded " + mt.getWeek());
        } catch (IOException e) {
            System.out.println("The file you wish to load does not exist");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMeal) {
            new AddMealTool(mt);
        } else if (e.getSource() == deleteMeal) {
            new DeleteFoodTool(mt);
        } else if (e.getSource() == viewMeal) {
            new ViewMealTool(mt);
        } else if (e.getSource() == editServings) {
            new EditServingsTool(mt);
        } else if (e.getSource() == save) {
            saveLog();
        } else if (e.getSource() == load) {
            loadLog();
        }
    }


    public static void main(String[] args) {
        new MealTrackerUI();
    }


}

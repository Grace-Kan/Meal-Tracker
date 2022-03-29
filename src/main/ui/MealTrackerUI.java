package ui;

import model.EventLog;
import model.Event;
import model.MealTracker;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

//represents a meal tracker GUI
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
    private JButton viewAllMeals;



    //EFFECTS: constructs a meal tracker up UI
    public MealTrackerUI() {
        mt = new MealTracker("My Meal Tracker");
        jsonWriter = new JsonWriter(FILE_NAME);
        jsonReader = new JsonReader(FILE_NAME);
        frame = new JFrame();
        panel = new JPanel();
        initializeButtons();
        setPanel();
        setFrame();

        addMeal.addActionListener(this);
        deleteMeal.addActionListener(this);
        viewMeal.addActionListener(this);
        editServings.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        viewAllMeals.addActionListener(this);


    }

    //MODIFIES: this
    //EFFECTS: initializes the menu buttons
    private void initializeButtons() {
        addMeal = new JButton("Add Meal");
        deleteMeal = new JButton("Delete Meal");
        viewMeal = new JButton("View Meals By Day and Meal Type");
        editServings = new JButton("Edit Servings");
        save = new JButton("Save Log");
        load = new JButton("Load Previous Log");
        viewAllMeals = new JButton("View All Meals");
    }

    //MODIFIES: this
    //EFFECTS: sets up menu panels and adds the menu buttons to the panel
    private void setPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panel.setLayout(new GridLayout(4,2));
        panel.add(addMeal);
        panel.add(deleteMeal);
        panel.add(viewAllMeals);
        panel.add(viewMeal);
        panel.add(editServings);
        panel.add(save);
        panel.add(load);

    }

    //MODIFIES: this
    //EFFECTS: sets up the starting menu frame
    private void setFrame() {
        frame.setTitle("My Meal Tracker");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(makeEventString());
                e.getWindow().dispose();
            }
        });
    }

    private static String makeEventString() {
        String s = "";
        for (Event e : EventLog.getInstance()) {
            s = s + e.getDescription() + "\n";
        }
        return s;
    }

    // MODIFIES: this
    // EFFECTS: converts mt into a JSON representation and adds it to a file with the file name
    // referenced from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
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

    //MODIFIES: this
    //EFFECTS: takes event input and display next panel corresponding to the button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMeal) {
            new AddMealTool(mt);
        } else if (e.getSource() == deleteMeal) {
            new DeleteFoodTool(mt);
        } else if (e.getSource() == viewAllMeals) {
            new ViewAllMeals(mt);
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


    //MODIFIES: this
    //EFFECTS: runs the meal tracker application
    public static void main(String[] args) {
        new MealTrackerUI();
    }


}

package ui.tools;

import model.FoodItem;
import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewAllMeals {
    private MealTracker mt;
    private JFrame frame;
    private JPanel panel;
    private JLabel mon;
    private JLabel tue;
    private JLabel wed;
    private JLabel thur;
    private JLabel fri;
    private JLabel sat;
    private JLabel sun;


    public ViewAllMeals(MealTracker mt) {
        this.mt = mt;
        mon = setText("Monday");
        tue = setText("Tuesday");
        wed = setText("Wednesday");
        thur = setText("Thursday");
        fri = setText("Friday");
        sat = setText("Saturday");
        sun = setText("Sunday");
        initializePanel();
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: sets up panel
    private void initializePanel() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panel.setLayout(new GridLayout(7, 1));
        panel.add(mon);
        panel.add(tue);
        panel.add(wed);
        panel.add(thur);
        panel.add(fri);
        panel.add(sat);
        panel.add(sun);
    }

    //EFFECTS: sets up the jLabels for the given day
    private JLabel setText(String day) {
        String s = setDayText(day);
        return new JLabel(s);
    }

    //EFFECTS: sets the food string labels by meal type
    private String setDayText(String day) {
        String s = day + ": " + setTextByMeal(day, "breakfast") + System.lineSeparator()
                + setTextByMeal(day, "lunch") + System.lineSeparator()
                + setTextByMeal(day,"dinner") + System.lineSeparator()
                + setTextByMeal(day,"dinner") + System.lineSeparator()
                + setTextByMeal(day, "snacks") + System.lineSeparator();

        return s;
    }

    //EFFECTS: converts the food items of day and meal type into string
    private String setTextByMeal(String day, String mealType) {
        ArrayList<FoodItem> logs = mt.getLogsByDayAndMealType(day, mealType);
        String s = mealType + ": ";
        for (FoodItem f : logs) {
            s = s + convertMealToString(f);
        }
        return s;
    }

    //EFFECTS: returns the food item in a string that shows the food name and servings
    private String convertMealToString(FoodItem f) {
        return f.getFoodTitle() + "(" + Double.toString(f.getServings()) + "), ";
    }

}

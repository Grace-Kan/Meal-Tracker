package ui.tools;

import model.FoodItem;
import model.MealTracker;

import javax.swing.ImageIcon;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//represents an add meal tool menu
public class AddMealTool extends ToolMenu {
    private JTextField foodName;
    private JTextField servings;

    private FoodItem foodItem;
    private MealTracker mt;


    //EFFECTS: constructs an add meal menu
    public AddMealTool(MealTracker mt) {
        super();
        this.mt = mt;
        actionPanel.add(submit);
        frame.add(actionPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: constructs the bottom panel that contains the text fields that allow users to enter food name & servings
    @Override
    protected void constructActionPanel() {
        super.constructActionPanel();
        actionPanel.setLayout(new GridLayout(3, 1));
        JLabel label1 = new JLabel("Food Name");
        JLabel label2 = new JLabel("Servings");
        foodName = new JTextField();
        servings = new JTextField();
        actionPanel.add(label1);
        actionPanel.add(foodName);
        actionPanel.add(label2);
        actionPanel.add(servings);

    }

    //EFFECTS: adds a food item with the entered food name, servings and meal type to mt. Displays a popup message
    // if incorrect value type was entered for servings or if required fields were not selected.
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            try {
                String day = dayGroup.getSelection().getActionCommand();
                String mealType = mealGroup.getSelection().getActionCommand();
                String name = foodName.getText();
                double serv = Double.parseDouble(servings.getText());
                foodItem = new FoodItem(name, mealType, serv);
                mt.addFoodToLogs(day, foodItem);
                frame.dispose();
                new PopupImage("./src/IMG_0130.jpg");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(frame, "Please select and enter all required fields");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please enter a correct value");
            }
        }
    }


    public FoodItem getFoodItem() {
        return foodItem;
    }

    public String getDay() {
        return day;
    }

}

package ui.tools;

import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//represents the day and meal selector for deleting food
public class DeleteFoodTool extends ToolMenu {
    private MealTracker mt;
    private String day;
    private String mealType;

    // EFFECTS: constructs a delete food menu
    public DeleteFoodTool(MealTracker mt) {
        super();
        this.mt = mt;
        actionPanel.add(submit);
        frame.add(actionPanel, BorderLayout.SOUTH);
        frame.setTitle("Please choose a day and meal type");
    }

    //EFFECTS: displays a new frame that allows users to select the food to delete when submit button is hit and displays
    // error message if required fields were not selected or if no food was logged for selected meal
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            try {
                day = dayGroup.getSelection().getActionCommand();
                mealType = mealGroup.getSelection().getActionCommand();
                if (mt.getLogsByDayAndMealType(day, mealType).size() == 0) {
                    JOptionPane.showMessageDialog(frame, "No food was logged");
                } else {
                    new DeleteEditor(mt, day, mealType, "delete");
                    frame.dispose();
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(frame, "Please select all fields");
            }
        }
    }
}

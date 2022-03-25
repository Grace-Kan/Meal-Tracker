package ui.tools;

import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//represents the day and meal selector for editing servings
public class EditServingsTool extends ToolMenu {
    private MealTracker mt;
    private String day;
    private String mealType;

    //EFFECTS: constructs an edit servings tool menu
    public EditServingsTool(MealTracker mt) {
        super();
        this.mt = mt;
        actionPanel.add(submit);
        frame.add(actionPanel, BorderLayout.SOUTH);
        frame.setTitle("Please choose a day and meal type");
        groupDays();
    }


    // EFFECTS: displays a new frame that allows user to select a food and edit its servings if submit button is pressed
    // and displays error message if required fields were not selected or if no food was logged for selected meal
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            try {
                day = dayGroup.getSelection().getActionCommand();
                mealType = mealGroup.getSelection().getActionCommand();
                if (mt.getLogsByDayAndMealType(day, mealType).size() == 0) {
                    JOptionPane.showMessageDialog(frame, "No food was logged");
                } else {
                    new ServingsEditor(mt, day, mealType, "Edit Servings");
                    frame.dispose();
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(frame, "Please select and enter in all required fields");
            }
        }
    }
}



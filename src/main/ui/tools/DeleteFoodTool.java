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

    //EFFECTS: displays a new frame that allows users to select the food to delete when submit button is hit
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            try {
                frame.dispose();
                day = dayGroup.getSelection().getActionCommand();
                mealType = mealGroup.getSelection().getActionCommand();
                new DeleteEditor(mt, day, mealType, "delete");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(frame, "Please select all fields");
            }
        }
    }
}

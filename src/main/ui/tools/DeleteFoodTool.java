package ui.tools;

import model.MealTracker;

import java.awt.*;
import java.awt.event.ActionEvent;

public class DeleteFoodTool extends ToolMenu {
    private MealTracker mt;
    private String day;
    private String mealType;

    public DeleteFoodTool(MealTracker mt) {
        super();
        this.mt = mt;
        actionPanel.add(submit);
        frame.add(actionPanel, BorderLayout.SOUTH);
        frame.setTitle("Please choose a day and meal type");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            frame.dispose();
            day = dayGroup.getSelection().getActionCommand();
            mealType = mealGroup.getSelection().getActionCommand();
            new DeleteEditor(mt, day, mealType, "delete");
        }
    }
}

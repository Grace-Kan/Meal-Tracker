package ui.tools;


import model.MealTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;

//represents a delete food frame
public class DeleteEditor extends Editor {

    //EFFECTS: constructs a menu that allows users to delete a selected food item of selected day and meal type
    public DeleteEditor(MealTracker mt, String day, String mealType, String buttonTitle) {
        super(mt, day, mealType, buttonTitle);

    }

    //EFFECTS: removes the chosen food item from mt and displays error message if no food was selected.
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("delete")) {
                String foodName = foodGroup.getSelection().getActionCommand();
                mt.getLog().removeFood(day, mealType, foodName);
                frame.dispose();
                new PopupImage("./src/IMG_0133.jpg");
            }
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(frame, "Please select a food");
        }
    }

}

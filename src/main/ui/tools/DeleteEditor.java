package ui.tools;

import model.FoodItem;
import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

//represents a delete food panel
public class DeleteEditor extends Editor {

    //EFFECTS: constructs a menu that allows users to delete a selected food item of selected day and meal type
    public DeleteEditor(MealTracker mt, String day, String mealType, String buttonTitle) {
        super(mt, day, mealType, buttonTitle);

    }

    //EFFECTS: removes the chosen food item from mt
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

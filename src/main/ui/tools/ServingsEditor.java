package ui.tools;

import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the panel that edits the servings of selected food
public class ServingsEditor extends DeleteEditor {
    private JPanel servingsPanel;
    private JTextField enterServings;
    private JLabel label;


    //EFFECTS: constructs an edit serving menu that allows users to select food item and enter a servings amount
    public ServingsEditor(MealTracker mt, String day, String mealType, String buttonTitle) {
        super(mt, day, mealType, buttonTitle);
        servingsPanel = new JPanel();
        enterServings = new JTextField();
        label = new JLabel("Please enter the amount to add");
        enterServings.setSize(20,5);
        servingsPanel.setLayout(new GridLayout(1, 2));
        servingsPanel.add(label);
        servingsPanel.add(enterServings);
        frame.add(servingsPanel, BorderLayout.CENTER);
        frame.setSize(1000, 350);
    }

    //MODIFIES: this
    //EFFECTS: changes and adds the entered servings amount to the selected food item
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Edit Servings")) {
            try {
                String foodName = foodGroup.getSelection().getActionCommand();
                String serv = enterServings.getText();
                mt.getLog().getMealsByDay(day).addServings(mealType, foodName, serv);
                frame.dispose();
                new PopupImage("./src/IMG_0134.jpg");
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(frame, "Please enter a correct value");
            } catch (NullPointerException ne) {
                JOptionPane.showMessageDialog(frame, "Please select a food");
            }
        }
    }

}

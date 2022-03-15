package ui;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import model.FoodItem;
import model.MealTracker;
import ui.tools.AddMealTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealTrackerUI implements ActionListener {
    private MealTracker mt;
    private JFrame frame;
    private JPanel panel;
    private JButton addMeal;
    private JButton deleteMeal;
    private JButton viewMeal;
    private JButton editServings;
    private JButton save;
    private JButton load;

    private AddMealTool addMealTool;



    public MealTrackerUI() {
        mt = new MealTracker("My Meal Tracker");
        frame = new JFrame();
        panel = new JPanel();
        initializeButtons();
        setPanel();
        setFrame();

        addMeal.addActionListener(this); //change addMealTool to this
        deleteMeal.addActionListener(this);
        viewMeal.addActionListener(this);
        editServings.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);


    }

    private void initializeButtons() {
        addMeal = new JButton("Add Meal");
        deleteMeal = new JButton("Delete Meal");
        viewMeal = new JButton("View Meals");
        editServings = new JButton("Edit Servings");
        save = new JButton("Save Log");
        load = new JButton("Load Previous Log");
    }

    private void setPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panel.setLayout(new GridLayout(3,2));
        panel.add(addMeal);
        panel.add(deleteMeal);
        panel.add(viewMeal);
        panel.add(editServings);
        panel.add(save);
        panel.add(load);

    }

    private void setFrame() {
        frame.setTitle("My Meal Tracker");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new MealTrackerUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMeal) {
            new AddMealTool(mt);
        } else if (e.getSource() == deleteMeal) {
            //TODO
        } else if (e.getSource() == viewMeal) {
            //TODO
            System.out.println(mt.getLog().logsToJson());
        } else if (e.getSource() == editServings) {
            //TODO
        } else if (e.getSource() == save) {
            //TODO
        } else if (e.getSource() == load) {
            //TODO
        }
    }

    public MealTracker getMt() {
        return mt;
    }
}

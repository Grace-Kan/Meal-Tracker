package ui.tools;

import model.FoodItem;
import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ViewMealTool extends ToolMenu {
    private MealTracker mt;
    private String day;
    private String mealType;

    public ViewMealTool(MealTracker mt) {
        super();
        this.mt = mt;
        actionPanel.add(submit);
        frame.add(actionPanel, BorderLayout.SOUTH);
        frame.setTitle("Choose day and meal type to view");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            day = dayGroup.getSelection().getActionCommand();
            mealType = mealGroup.getSelection().getActionCommand();
            ArrayList<FoodItem> log = mt.getLogsByDayAndMealType(day,mealType);
            JFrame f = new JFrame();
            JPanel p = new JPanel();
            setViewMeal(p, log);
            p.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
            p.setLayout(new GridLayout(10, log.size() / 10));
            f.add(p, BorderLayout.CENTER);
            frame.setPreferredSize(new Dimension(600, 450));
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.pack();
            f.setVisible(true);



        }
    }

    private String convertMealToString(FoodItem f) {
        String s;
        s = "Food Name: " + f.getFoodTitle() + System.lineSeparator() + ", " + "Servings: "
                + Double.toString(f.getServings());
        return s;
    }

    private void setViewMeal(JPanel panel, ArrayList<FoodItem> foodItems) {
        for (FoodItem f : foodItems) {
            JLabel label = new JLabel(convertMealToString(f));
            panel.add(label);
        }
    }





}

package ui.tools;

import model.FoodItem;
import model.MealTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class SelectFoodTool implements ActionListener {
    private MealTracker mt;
    private String day;
    private String mealType;
    private JFrame frame;
    private JPanel panel;
    private JPanel deletePanel;
    private JButton delete;
    private List<JRadioButton> foods;

    private static ButtonGroup foodGroup = new ButtonGroup();
    private static int ROWS = 5;

    public SelectFoodTool(MealTracker mt, String day, String mealType) {
        this.mt = mt;
        this.day = day;
        this.mealType = mealType;
        this.foods = new LinkedList<>();
        initializeRadioButtons(mt, day, mealType);
        initializePanel();
        initializeFrame();
        delete = new JButton("delete");
        delete.addActionListener(this);
        JPanel deletePanel = new JPanel();
        deletePanel.add(delete);
        frame.add(deletePanel, BorderLayout.SOUTH);

    }

    private void addJRadioButtons() {
        for (JRadioButton rb : foods) {
            panel.add(rb);
        }
    }

    private void addJRadioButtonsToGroup() {
        for (JRadioButton rb : foods) {
            foodGroup.add(rb);
        }
    }

    private void setActionCommandFoods(List<FoodItem> foodItems) {
        int i = 0;
        for (JRadioButton rb : foods) {
            rb.setActionCommand(foodItems.get(i).getFoodTitle());
            i++;
        }
    }

    private void initializeRadioButtons(MealTracker mt, String day, String mealType) {
        List<FoodItem> foodItems = mt.getLogsByDayAndMealType(day, mealType);
        for (FoodItem f : foodItems) {
            String buttonTitle = f.getFoodTitle() + "  (" + Double.toString(f.getServings()) + " servings" + ")";
            foods.add(new JRadioButton(buttonTitle));
        }
        addJRadioButtonsToGroup();
        setActionCommandFoods(foodItems);
    }

    private void initializePanel() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
        panel.setLayout(new GridLayout(ROWS, foods.size() / ROWS));
        addJRadioButtons();
    }

    private void initializeFrame() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 450));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("delete")) {
            String foodName = foodGroup.getSelection().getActionCommand();
            mt.getLog().removeFood(day, mealType, foodName);
            frame.dispose();
        }
    }
}

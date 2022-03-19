package ui.tools;

import model.FoodItem;
import model.MealTracker;

import javax.swing.ImageIcon;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddMealTool extends ToolMenu {
    private JTextField foodName;
    private JTextField servings;

    private FoodItem foodItem;
    private MealTracker mt;

    public AddMealTool(MealTracker mt) {
        super();
        this.mt = mt;
        actionPanel.add(submit);
        frame.add(actionPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void constructActionPanel() {
        super.constructActionPanel();
        actionPanel.setLayout(new GridLayout(3, 1));
        JLabel label1 = new JLabel("Food Name");
        JLabel label2 = new JLabel("Servings");
        foodName = new JTextField();
        servings = new JTextField();
        actionPanel.add(label1);
        actionPanel.add(foodName);
        actionPanel.add(label2);
        actionPanel.add(servings);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("submit")) {
            day = dayGroup.getSelection().getActionCommand();
            mealType = mealGroup.getSelection().getActionCommand();
            String name = foodName.getText();
            try {
                double serv = Double.parseDouble(servings.getText());
                foodItem = new FoodItem(name, mealType, serv);
                mt.addFoodToLogs(day, foodItem);
                frame.dispose();
                setPopupImage();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Illegal value type was entered");

            }
        }
    }

    // taken from https://stackoverflow.com/questions/29636217/how-to-have-an-image-pop-up-in-java
    private void setPopupImage() {
        JFrame f = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon image = new ImageIcon("./data/IMG_0130.jpg");
        JLabel lbl = new JLabel(image);
        f.getContentPane().add(lbl);
        f.setSize(image.getIconWidth(), image.getIconHeight());

        int x = (screenSize.width - f.getSize().width) / 2;
        int y = (screenSize.height - f.getSize().height) / 2;

        f.setLocation(x, y);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public String getDay() {
        return day;
    }

}

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
public class DeleteEditor implements ActionListener {
    protected MealTracker mt;
    protected String day;
    protected String mealType;
    protected JFrame frame;
    protected JPanel panel;
    protected JPanel actionPanel;
    protected JButton button;
    protected List<JRadioButton> foods;

    protected static ButtonGroup foodGroup = new ButtonGroup();
    protected static int ROWS = 5;


    //EFFECTS: constructs a menu that allows users to delete a selected food item of selected day and meal type
    public DeleteEditor(MealTracker mt, String day, String mealType, String buttonTitle) {
        this.mt = mt;
        this.day = day;
        this.mealType = mealType;
        this.foods = new LinkedList<>();
        initializeRadioButtons(mt, day, mealType);
        initializePanel();
        initializeFrame();
        button = new JButton(buttonTitle);
        button.addActionListener(this);
        actionPanel = new JPanel();
        actionPanel.add(button);
        frame.add(actionPanel, BorderLayout.SOUTH);

    }

    //MODIFIES: this
    //EFFECTS: adds the jradio buttons from foods to panel
    protected void addJRadioButtons() {
        for (JRadioButton rb : foods) {
            panel.add(rb);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds the radio buttons to the button group
    protected void addJRadioButtonsToGroup() {
        for (JRadioButton rb : foods) {
            foodGroup.add(rb);
        }
    }

    //EFFECTS: sets up the action command for each radio buttons by the food title of the items in foodItems
    protected void setActionCommandFoods(List<FoodItem> foodItems) {
        int i = 0;
        for (JRadioButton rb : foods) {
            rb.setActionCommand(foodItems.get(i).getFoodTitle());
            i++;
        }
    }

    //MODIEFIES: this
    //EFFECTS: sets up the radio buttons
    protected void initializeRadioButtons(MealTracker mt, String day, String mealType) {
        List<FoodItem> foodItems = mt.getLogsByDayAndMealType(day, mealType);
        for (FoodItem f : foodItems) {
            String buttonTitle = f.getFoodTitle() + "  (" + Double.toString(f.getServings()) + " servings" + ")";
            foods.add(new JRadioButton(buttonTitle));
        }
        addJRadioButtonsToGroup();
        setActionCommandFoods(foodItems);
    }

    //MODIFIES: this
    //EFFECTS: constructs and sets up the panel
    protected void initializePanel() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panel.setLayout(new GridLayout(ROWS, foods.size() / ROWS));
        addJRadioButtons();
    }

    //MODIFIES: this
    //EFFECTS: constructs the delete food menu frame
    protected void initializeFrame() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 450));
        frame.add(panel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Please select a day and meal to edit");

    }

    //EFFECTS: removes the chosen food item from mt
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("delete")) {
                String foodName = foodGroup.getSelection().getActionCommand();
                mt.getLog().removeFood(day, mealType, foodName);
                frame.dispose();
                setPopupImage();
            }
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(frame, "Please select a food");
        }
    }

    // taken from https://stackoverflow.com/questions/29636217/how-to-have-an-image-pop-up-in-java
    // EFFECTS: sets up and displays the pop up image for when a food item was added.
    private void setPopupImage() {
        JFrame f = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon image = new ImageIcon("./src/IMG_0133.jpg");
        JLabel lbl = new JLabel(image);
        f.getContentPane().add(lbl);
        f.setSize(image.getIconWidth(), image.getIconHeight());

        int x = (screenSize.width - f.getSize().width) / 2;
        int y = (screenSize.height - f.getSize().height) / 2;

        f.setLocation(x, y);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}

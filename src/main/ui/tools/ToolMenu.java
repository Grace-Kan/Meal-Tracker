package ui.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ToolMenu implements ActionListener {
    protected JRadioButton mon;
    protected JRadioButton tues;
    protected JRadioButton wed;
    protected JRadioButton thurs;
    protected JRadioButton fri;
    protected JRadioButton sat;
    protected JRadioButton sun;

    private JRadioButton breakfast;
    private JRadioButton lunch;
    private JRadioButton dinner;
    private JRadioButton snacks;

    protected JFrame frame;
    protected JPanel dayPanel;
    protected JPanel mealPanel;
    protected JPanel actionPanel;
    protected JButton submit;

    protected String day;
    protected String mealType;

    protected static ButtonGroup dayGroup = new ButtonGroup();
    protected static ButtonGroup mealGroup = new ButtonGroup();

    public ToolMenu() {
        initializeDays();
        initializeMeals();
        constructDayPanel();
        constructMealPanel();
        constructActionPanel();
        constructFrame();
        setActionCommandDays();
        setActionCommandMeals();
        groupDays();
        groupMeals();
        submit = new JButton("submit");

        submit.addActionListener(this);
    }

    protected void initializeDays() {
        mon = new JRadioButton("Monday");
        tues = new JRadioButton("Tuesday");
        wed = new JRadioButton("Wednesday");
        thurs = new JRadioButton("Thursday");
        fri = new JRadioButton("Friday");
        sat = new JRadioButton("Saturday");
        sun = new JRadioButton("Sunday");
    }

    protected void initializeMeals() {
        breakfast = new JRadioButton("breakfast");
        lunch = new JRadioButton("lunch");
        dinner = new JRadioButton("dinner");
        snacks = new JRadioButton("snacks");
    }

    protected void constructDayPanel() {
        dayPanel = new JPanel();
        dayPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        dayPanel.setLayout(new GridLayout(4,2));
        dayPanel.add(mon);
        dayPanel.add(fri);
        dayPanel.add(tues);
        dayPanel.add(sat);
        dayPanel.add(wed);
        dayPanel.add(sun);
        dayPanel.add(thurs);
    }

    protected void constructMealPanel() {
        mealPanel = new JPanel();
        mealPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        mealPanel.setLayout(new GridLayout(2,2));
        mealPanel.add(breakfast);
        mealPanel.add(lunch);
        mealPanel.add(dinner);
        mealPanel.add(snacks);

    }

    protected void constructActionPanel() {
        actionPanel = new JPanel();
        mealPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));

    }

    protected void constructFrame() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 450));
        frame.add(dayPanel, BorderLayout.NORTH);
        frame.add(mealPanel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    protected void setActionCommandDays() {
        mon.setActionCommand("Monday");
        tues.setActionCommand("Tuesday");
        wed.setActionCommand("Wednesday");
        thurs.setActionCommand("Thursday");
        fri.setActionCommand("Friday");
        sat.setActionCommand("Saturday");
        sun.setActionCommand("Sunday");
    }

    protected void setActionCommandMeals() {
        breakfast.setActionCommand("breakfast");
        lunch.setActionCommand("lunch");
        dinner.setActionCommand("dinner");
        snacks.setActionCommand("snacks");
    }

    protected void groupDays() {
        dayGroup.add(mon);
        dayGroup.add(tues);
        dayGroup.add(wed);
        dayGroup.add(thurs);
        dayGroup.add(fri);
        dayGroup.add(sat);
        dayGroup.add(sun);
    }

    protected void groupMeals() {
        mealGroup.add(breakfast);
        mealGroup.add(lunch);
        mealGroup.add(dinner);
        mealGroup.add(snacks);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("submit")) {
            day = dayGroup.getSelection().getActionCommand();
            mealType = mealGroup.getSelection().getActionCommand();
        }
    }

}

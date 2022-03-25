package ui.tools;

import javax.swing.*;
import java.awt.*;

//represents a pop up image
public class PopupImage {
    private JFrame frame;
    private JLabel label;
    private ImageIcon image;

    // taken from https://stackoverflow.com/questions/29636217/how-to-have-an-image-pop-up-in-java
    // EFFECTS: sets up and displays a popup image
    public PopupImage(String fileName) {
        frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image = new ImageIcon(fileName);
        label = new JLabel(image);
        frame.getContentPane().add(label);
        frame.setSize(image.getIconWidth(), image.getIconHeight());

        int x = (screenSize.width - frame.getSize().width) / 2;
        int y = (screenSize.height - frame.getSize().height) / 2;

        frame.setLocation(x, y);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}

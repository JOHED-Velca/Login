package GUIS;

import constants.CommonConstants;

import javax.swing.*;

public class Form extends JFrame {
    //create a constructor
    public Form(String title) {
        //title bar
        super(title);

        //GUI size
        setSize(520, 680);

        //configure GUI tto end process after closing
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set layout to disable layout management so we can use absolute positioning
        //to place the components wherever we want
        setLayout(null);

        //load GUI in the center of the screen
        setLocationRelativeTo(null);

        //prevent GUI from changing size
        setResizable(false);

        //GUI's background color
        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
    }
}

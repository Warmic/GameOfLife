package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Base b = new Base();

        f.add(new Base());
        f.setSize(640,840);
        f.setVisible(true);
        Point p =new Point(1,1);


    }
}

package com.yuliandr.learhProject.tanks.view;

import javax.swing.*;
import java.awt.*;

public abstract class Display {
    private static boolean created = false;//flag is the window already created or not
    public static JFrame window;
    public static Canvas content;

    public static void create(int width, int height, String title) {
        if (created) {
            return;
        }
        window = new JFrame(title);//frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();//area
        Dimension size = new Dimension(width, height);//encapsulates screen area dimensions
        content.setPreferredSize(size);
        window.setResizable(false);//user can't change sizes of windows
        window.getContentPane().add(content);//
        window.pack();//resizes the window to match the content size
        window.setLocationRelativeTo(null);//center
        window.setVisible(true);
    }


}

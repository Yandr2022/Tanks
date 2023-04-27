package com.yuliandr.learhProject.tanks.controller;

import com.yuliandr.learhProject.tanks.view.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Main {
    public static void main(String[] args) {
        Display.create(800, 600, "Tanks", 0xff00ff00,3);
        Timer timer = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.clear();
//                Display.render();
                Display.swapBuffers();

            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}
//0123456789abcdef, byte 0xff - 0x00, int 0x_Transparent>ff_Red>ff_Green>ff_Blue>ff - 0x00
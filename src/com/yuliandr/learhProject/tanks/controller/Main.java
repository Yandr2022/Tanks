package com.yuliandr.learhProject.tanks.controller;

import com.yuliandr.learhProject.tanks.view.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Main {
    public static void main(String[] args) {
        Display.create(800, 600, "Tanks");
        Timer timer = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}

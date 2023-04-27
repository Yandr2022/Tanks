package com.yuliandr.learhProject.tanks.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;


public abstract class Display {
    private static boolean created = false;//flag is the window already created or not
    private static JFrame window;
    private static Canvas content;
    private static BufferedImage buffer;
    private static int[] bufferData;//buffer content, array with rgb
    private static Graphics bufferGraphics;
    private static int _clearColor;
//temp start
    private static  float delta = 0;

//temp end
    public static void create(int width, int height, String title, int clearColor) {
        if (created) {
            return;
        }
        window = new JFrame(title);//frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();//area
        _clearColor = clearColor;

        Dimension size = new Dimension(width, height);//encapsulates screen area dimensions
        content.setPreferredSize(size);

        window.setResizable(false);//user can't change sizes of windows
        window.getContentPane().add(content);//
        window.pack();//resizes the window to match the content size
        window.setLocationRelativeTo(null);//center
        window.setVisible(true);

        buffer = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();

        created = true;
    }

    public static void clear(){
        Arrays.fill(bufferData,_clearColor);
    }
    public static void render(){
        bufferGraphics.setColor(new Color(0xff0000ff));
        bufferGraphics.fillOval((int)(350 + (Math.sin(delta) * 200)),250,100,100);
        delta +=0.02f;

    }
    public static void swapBuffers(){
       Graphics gr = content.getGraphics();
       gr.drawImage(buffer,0,0,null);
    }


}

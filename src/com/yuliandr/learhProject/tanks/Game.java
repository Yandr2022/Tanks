package com.yuliandr.learhProject.tanks;

import com.yuliandr.learhProject.tanks.utils.Time;

public class Game implements Runnable {
    //int width, int height, String title, int clearColor, int numBuffers = create func params
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff_00_00_00;
    public static final int NUM_BUFFERS = 3;
    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;

    public Game() {
    }

    public synchronized void start() {

    }

    public synchronized void stop() {

    }

    private void update(){

    }

    private void render(){

    }

    @Override
    public void run() {

    }

    private void cleanUp(){

    }

}

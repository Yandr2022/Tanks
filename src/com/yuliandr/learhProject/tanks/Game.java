package com.yuliandr.learhProject.tanks;

import com.yuliandr.learhProject.tanks.utils.Time;
import com.yuliandr.learhProject.tanks.view.Display;

public class Game implements Runnable {
    //int width, int height, String title, int clearColor, int numBuffers = create func params
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff_00_00_00;
    public static final int NUM_BUFFERS = 3;
    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;//time between updates
    public static final long IDLE_TIME = 1;//time for rest thread (ms = 1000 ns)

    private boolean running;
    private Thread gameThread;

    public Game() {
        running = false;
        Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();//start method this.run()

    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();//wait for all threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cleanUp();
    }

    private void update() {

    }

    private void render() {

    }

    @Override
    public void run() {
        int fps = 0, upd = 0, updloop = 0;

        long count = 0;//games Time

        float delta = 0;//update num(60/sec)

        long lastTime = Time.getCurrentTime();
        while (running) {
            long currentTime = Time.getCurrentTime();
            long elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            count+=elapsedTime;

            boolean render = false;//has changes?
            delta += (elapsedTime / UPDATE_INTERVAL);
            while (delta > 1) {
                update();
                upd++;
                delta--;
                if (render) {
                    upd++;
                } else {
                    render = true;
                }
            }
            if (render) {
                render();
                fps++;
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count>=Time.SECOND){

            };

        }
    }

    private void cleanUp() {//closed resources
        Display.destroy();
    }

}

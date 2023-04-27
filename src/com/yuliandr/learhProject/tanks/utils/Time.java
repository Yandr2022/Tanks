package com.yuliandr.learhProject.tanks.utils;

public class Time {
    public static final long SECOND = 1000_000_000L;
    public static long getCurrentTime(){
        return System.nanoTime();
    }
}

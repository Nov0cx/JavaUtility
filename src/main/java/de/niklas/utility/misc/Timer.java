package de.niklas.utility.misc;

public class Timer {
    private long time;

    public void add() {
        time++;
    }

    public long getTime() {
        return time;
    }

    public void reset() {
        time = 0;
    }

    public long getAndReset() {
        long t = getTime();
        reset();
        return t;
    }
}

package max.sander;

public class Timer {
    private long msElapsed = 0;
    private long lastStart;
    private boolean running = false;
    public Timer() {
    }
    public void start() {
        if (!running) {
            running = true;
            lastStart = System.currentTimeMillis();
        }
    }
    public void stop() {
        if (running) {
            msElapsed += System.currentTimeMillis() - lastStart;
            running = false;
        }
    }
    public long getTimeMilliseconds() {
        if (!running) {
            return msElapsed;
        } else {
            return msElapsed + System.currentTimeMillis() - lastStart;
        }
    }
}

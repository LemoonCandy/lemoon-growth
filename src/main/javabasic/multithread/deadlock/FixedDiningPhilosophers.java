package main.javabasic.multithread.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lee
 * @date 2020-12-06
 */
public class FixedDiningPhilosophers {
    public static void main(String[] args) throws Exception{
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        ChopStick[] sticks = new ChopStick[size];
        for (int i = 0; i < 5; i++) {
            sticks[i] = new ChopStick();
        }
        for (int i = 0; i < 4; i++) {
            exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, ponder));
        }
        exec.execute(new Philosopher(sticks[0],sticks[4],4,ponder));
        System.out.println("Press 'Enter' to quit");
        System.in.read();
        exec.shutdownNow();
    }
}

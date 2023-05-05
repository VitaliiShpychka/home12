package home1;

import java.time.Duration;
import java.time.Instant;

    public class Main {

        public static void main(String[] args) {
            Thread timerThread = new Thread(() -> {
                Instant start = Instant.now();
                while (true) {
                    Instant current = Instant.now();
                    Duration elapsed = Duration.between(start, current);
                    System.out.println(elapsed.getSeconds() + " seconds passed.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread messageThread = new Thread(() -> {
                while (true) {

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Passed 5 seconds.");
                }
            });

            timerThread.start();
            messageThread.start();
        }
    }




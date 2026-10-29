package ru.aston.hometask2.threads;

public class TwoThreadsExample {
    private static final Object monitor = new Object();
    private static boolean isFirstThreadTurn = true;

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    while (!isFirstThreadTurn) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("1");
                    isFirstThreadTurn = false;
                    monitor.notifyAll();
                }
            }
        });

        final Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    while (isFirstThreadTurn) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("2");
                    isFirstThreadTurn = true;
                    monitor.notifyAll();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
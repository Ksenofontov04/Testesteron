package ru.ssau.Laba_7.concurrent;

import ru.ssau.Laba_7.functions.LinkedListTabulatedFunction;
import ru.ssau.Laba_7.functions.TabulatedFunction;
import ru.ssau.Laba_7.functions.UnitFunction;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction tabulatedFunction = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1000, 20000);
        int numberOfThreads = 10;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            Runnable task = new MultiplyingTask(tabulatedFunction, latch);
            executor.execute(task);
        }

        latch.await();
        executor.shutdown();

        System.out.println(tabulatedFunction);
    }
}

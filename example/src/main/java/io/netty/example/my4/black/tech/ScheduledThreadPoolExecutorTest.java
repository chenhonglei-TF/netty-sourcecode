package io.netty.example.my4.black.tech;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
    ScheduledThreadPoolExecutor 在 ThreadPoolExecutor 的基础上，重新设计了任务 ScheduledFutureTask 和阻塞队列 DelayedWorkQueue。
    ScheduledFutureTask 继承于 FutureTask，并重写了 run() 方法，使其具备周期执行任务的能力。
    DelayedWorkQueue 内部是优先级队列，deadline 最近的任务在队列头部。对于周期执行的任务，在执行完会重新设置时间，并再次放入队列中
 */
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        // 1s 延迟后开始执行任务，每 2s 重复执行一次
        executor.scheduleAtFixedRate(() -> System.out.println("Hello World"), 1000, 2000, TimeUnit.MILLISECONDS);
    }
}

package io.netty.example.my4.black.tech;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {

    public static void main(String[] args) {
        Timer timer = new HashedWheelTimer();
        Timeout t1 = timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout1: " + new Date());
            }
        }, 10, TimeUnit.SECONDS);
        if (!t1.isExpired()) {
            t1.cancel();
        }

        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout2: " + new Date());
                // 时间轮中的任务执行是串行的，当一个任务执行的时间过长，会影响后续任务的调度和执行，很可能产生任务堆积的情况。
                Thread.sleep(5000);
            }
        }, 1, TimeUnit.SECONDS);

        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout3: " + new Date());
            }
        }, 3, TimeUnit.SECONDS);
    }
}

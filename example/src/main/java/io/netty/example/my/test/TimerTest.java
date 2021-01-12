package io.netty.example.my.test;

import java.util.Timer;
import java.util.TimerTask;

/*
Timer 属于 JDK 比较早期版本的实现，它可以实现固定周期的任务，以及延迟任务。
Timer 会起动一个异步线程去执行到期的任务，任务可以只被调度执行一次，也可以周期性反复执行多次

TaskQueue 是由数组结构实现的小根堆，deadline 最近的任务位于堆顶端，queue[1] 始终是最优先被执行的任务。
所以使用小根堆的数据结构，Run 操作时间复杂度 O(1)，新增 Schedule 和取消 Cancel 操作的时间复杂度都是 O(logn)。

Timer 内部启动了一个 TimerThread 异步线程，不论有多少任务被加入数组，始终都是由 TimerThread 负责处理。
TimerThread 会定时轮询 TaskQueue 中的任务，如果堆顶的任务的 deadline 已到，那么执行任务；
如果是周期性任务，执行完成后重新计算下一次任务的 deadline，并再次放入小根堆；
如果是单次执行的任务，执行结束后会从 TaskQueue 中删除。

 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }, 10000, 1000);  // 10s 后调度一个周期为 1s 的定时任务
    }
}

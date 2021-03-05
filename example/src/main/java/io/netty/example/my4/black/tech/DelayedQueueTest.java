package io.netty.example.my4.black.tech;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
    DelayedQueue 是 JDK 中一种可以延迟获取对象的阻塞队列，其内部是采用优先级队列 PriorityQueue 存储对象。
    DelayQueue 中的每个对象都必须实现 Delayed 接口，并重写 compareTo 和 getDelay 方法

    DelayQueue 提供了 put() 和 take() 的阻塞方法，可以向队列中添加对象和取出对象。
    对象被添加到 DelayQueue 后，会根据 compareTo() 方法进行优先级排序。getDelay() 方法用于计算消息延迟的剩余时间，
    只有 getDelay <=0 时，该对象才能从 DelayQueue 中取出。

    相比于 Timer，DelayQueue 只实现了任务管理的功能，需要与异步线程配合使用。DelayQueue 使用优先级队列实现任务的优先级排序，新增 Schedule 和取消 Cancel 操作的时间复杂度也是 O(logn)。
 */
public class DelayedQueueTest {

    public static void main(String[] args) throws Exception {
        BlockingQueue<SampleTask> delayQueue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        delayQueue.put(new SampleTask(now + 1000));
        delayQueue.put(new SampleTask(now + 2000));
        delayQueue.put(new SampleTask(now + 3000));

        for (int i = 0; i < 3; i++) {
            System.out.println(new Date(delayQueue.take().getTime()));
        }
    }


    static class SampleTask implements Delayed {
        long time;

        public SampleTask(long time) {
            this.time = time;
        }

        public long getTime() {
            return time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {

            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}

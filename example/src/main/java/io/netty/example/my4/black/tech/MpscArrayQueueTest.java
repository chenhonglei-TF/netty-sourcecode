package io.netty.example.my4.black.tech;

import org.jctools.queues.MpscArrayQueue;

public class MpscArrayQueueTest {

    private static final MpscArrayQueue<String> MPSC_ARRAY_QUEUE = new MpscArrayQueue<>(2);

    public static void main(String[] args) {
        for (int i = 1; i <=2 ; i++) {
            int idx = i;
            new Thread(() -> MPSC_ARRAY_QUEUE.offer("data" + idx), "thread-"+idx).start();
        }

        try {
            Thread.sleep(1000L);
            MPSC_ARRAY_QUEUE.add("data3");
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("队列大小："+MPSC_ARRAY_QUEUE.size() + ", 队列容量："+MPSC_ARRAY_QUEUE.capacity());
        System.out.println("出队："+MPSC_ARRAY_QUEUE.remove());
        System.out.println("出队：" + MPSC_ARRAY_QUEUE.poll());
        System.out.println("队列大小："+MPSC_ARRAY_QUEUE.size() + ", 队列容量："+MPSC_ARRAY_QUEUE.capacity());
    }
}

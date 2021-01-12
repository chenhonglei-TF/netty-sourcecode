package io.netty.example.my.test;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

public class FastThreadLocalTest {
    private static final FastThreadLocal<String> THREAD_NAME_LOCAL = new FastThreadLocal<>();
    private static final FastThreadLocal<TradeOrder> TRADE_THREAD_LOCAL = new FastThreadLocal<>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int tradeId = i;
            String threadName = "thread-" + i;
            new FastThreadLocalThread(() -> {
                THREAD_NAME_LOCAL.set(threadName);
                TradeOrder tradeOrder = new TradeOrder(tradeId, tradeId % 2 == 0 ? "已支付" : "未支付");
                TRADE_THREAD_LOCAL.set(tradeOrder);
                System.out.println("threadName: " + THREAD_NAME_LOCAL.get());
                System.out.println("tradeOrder info：" + TRADE_THREAD_LOCAL.get());
            }, threadName).start();
        }
    }
}

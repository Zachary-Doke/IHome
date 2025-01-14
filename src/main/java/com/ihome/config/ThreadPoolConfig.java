package com.ihome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ThreadPoolConfig {
    /**
     * 核心线程池大小
     */
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    /**
     * 最大可创建的线程数
     */
    private static final int MAXIMUM_POOL_SIZE = CORE_POOL_SIZE * 2 + 1;

    /**
     * 队列最大长度
     */
    private static final int QUEUE_CAPACITY = 50000;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private static final int KEEP_ALIVE_TIME = 60;

    @Bean
    public ExecutorService executorService() {
        AtomicInteger c = new AtomicInteger(1);
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(QUEUE_CAPACITY);
        return new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                queue,
                r -> new Thread(r,"ThreadPool"+c.getAndIncrement()),
                new ThreadPoolExecutor.DiscardPolicy()
        );
    }

}
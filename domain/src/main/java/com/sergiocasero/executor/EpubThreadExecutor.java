package com.sergiocasero.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sergiocasero on 16/2/16.
 */
public class EpubThreadExecutor implements Executor{

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAXIMUM_POOL_SIZE = 6;
    private static final long KEEP_ALIVE_TIME = 30;
    private final ThreadPoolExecutor threadPoolExecutor;
    private final ThreadFactory threadFactory;

    public EpubThreadExecutor(){
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
        threadFactory = new ThreadEpubFactory();
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, timeUnit, workQueue, threadFactory);
    }

    @Override
    public void execute(Runnable command) {
        if(command == null){
            throw new IllegalArgumentException("Interactor is null!!");
        }

        threadPoolExecutor.execute(command);
    }

    public class ThreadEpubFactory implements ThreadFactory{


        private static final String NAME = "epub_";

        AtomicLong counter = new AtomicLong(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, NAME + counter.getAndIncrement());
        }
    }
}

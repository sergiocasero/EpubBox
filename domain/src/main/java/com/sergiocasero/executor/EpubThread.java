package com.sergiocasero.executor;

import rx.Scheduler;

/**
 * Created by sergiocasero on 16/2/16.
 */
public interface EpubThread {
    Scheduler getScheduler();
}

package com.sergiocasero.interactor;

import com.sergiocasero.executor.EpubThread;
import com.sergiocasero.executor.EpubThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by sergiocasero on 16/2/16.
 */
public abstract class Interactor {
    private final EpubThreadExecutor threadExecutor;
    private final EpubThread epubThread;
    private Subscription subscription = Subscriptions.empty();

    public Interactor(EpubThreadExecutor epubThreadExecutor, EpubThread epubThread){
        this.threadExecutor = epubThreadExecutor;
        this.epubThread = epubThread;
    }

    public void execute(Subscriber subscriber){
        subscription = buildInteractorObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(epubThread.getScheduler())
                .subscribe(subscriber);
    }


    public abstract Observable buildInteractorObservable();

    public void unsubscribe(){
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}

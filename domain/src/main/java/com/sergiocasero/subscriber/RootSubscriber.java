package com.sergiocasero.subscriber;

import rx.Subscriber;

/**
 * Created by sergiocasero on 16/2/16.
 */
public class RootSubscriber <T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        this.unsubscribe();
    }

    @Override
    public void onError(Throwable e) {
        this.unsubscribe();
    }

    @Override
    public void onNext(T t) {

    }
}
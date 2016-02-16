package com.sergiocasero.epubbox.presenter;

/**
 * Created by sergiocasero on 16/2/16.
 */
public abstract class Presenter<V> {
    protected V view;

    public void setView(V view){
        if(view == null){
            throw new RuntimeException("Presenter needs a view!");
        }
        this.view = view;
    }

    public abstract void initialize();

    public abstract void destroy();
}

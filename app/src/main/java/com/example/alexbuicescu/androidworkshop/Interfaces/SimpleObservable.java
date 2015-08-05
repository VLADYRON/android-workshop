package com.example.alexbuicescu.androidworkshop.Interfaces;

import java.util.ArrayList;

/**
 * Created by alexbuicescu on 05.08.2015.
 */
public class SimpleObservable<T> implements EasyObservable<T> {

    private ArrayList<OnChangeListener<T>> listeners = new ArrayList<>();

    @Override
    public void addListener(OnChangeListener<T> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(OnChangeListener<T> listener) {
        listeners.remove(listener);
    }

    public void notifyObservers()
    {
        for(OnChangeListener<T> listener : listeners)
        {
            listener.onChange();
        }
    }
}

package com.xjj.java.designpattern.observer;

/**
 * ·¢²¼Õß
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

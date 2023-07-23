package com.xjj.java.designpattern.observer;

/**
 * ¶ÌĞÅÍ¨Öª
 */
public class MessageObserver implements Observer{

    @Override
    public void sendMessage(String msg) {
        System.out.println("MessageObserver receive msg:"+msg);
    }
}

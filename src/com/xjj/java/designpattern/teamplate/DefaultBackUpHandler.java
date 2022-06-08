package com.xjj.java.designpattern.teamplate;

public class DefaultBackUpHandler extends BackUpFactory implements IBackUpHandler{

    public DefaultBackUpHandler(IBackUpHandler backUpHandler) {
        super(backUpHandler);
    }

    public DefaultBackUpHandler() {
    }

    @Override
    public void method1() {
        System.out.println("DefaultBackUpData overwrite method1");
    }

    @Override
    public void method2() {
        System.out.println("DefaultBackUpData ---->method2");
    }

    @Override
    public void doBackUp(MyContext context) {
        doExportFile(context);
    }
}

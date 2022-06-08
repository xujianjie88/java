package com.xjj.java.designpattern.teamplate;

public class BigDataBackUpHandler extends BackUpFactory implements IBackUpHandler{

    public BigDataBackUpHandler(IBackUpHandler backUpHandler) {
        super(backUpHandler);
    }

    public BigDataBackUpHandler() {
    }

    @Override
    public void doBackUp(MyContext context) {
        doExportFile(context);
    }

    @Override
    public void method2() {
        System.out.println("BigDataBackUpHandler ---->method2()");
    }
}

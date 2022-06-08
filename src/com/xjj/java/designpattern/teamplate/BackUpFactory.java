package com.xjj.java.designpattern.teamplate;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class BackUpFactory {

    private IBackUpHandler backUpHandler;

    public BackUpFactory(IBackUpHandler backUpHandler){
       this.backUpHandler = backUpHandler;
    }

    public void doExportFile(MyContext myContext){
        System.out.println("========>com.xjj.java.designpattern.teamplate.IBackUpFactory.doExportFile");
        method1();
        method2();
    }

    public abstract void method2();

    public void method1() {

    }

}

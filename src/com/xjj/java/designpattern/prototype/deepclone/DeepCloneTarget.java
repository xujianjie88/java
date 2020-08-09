package com.xjj.java.designpattern.prototype.deepclone;

import java.io.Serializable;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 14:54
 **/
public class DeepCloneTarget implements Cloneable, Serializable {

    private String cloneName;

    private String cloneTarget;

    public DeepCloneTarget(String cloneName, String cloneTarget) {
        this.cloneName = cloneName;
        this.cloneTarget = cloneTarget;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

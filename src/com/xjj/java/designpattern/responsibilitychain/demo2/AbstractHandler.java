package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;

public abstract class AbstractHandler {

    // �������е���һ������
    private AbstractHandler nextHandler;

    /**
     * ����������һ������
     */
    public void setNextHandler(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    /**
     * ������������߼�,������ȥʵ��
     */
    public void filter(Request request, Response response) {
        doFilter(request, response);
        if (getNextHandler() != null) {
            getNextHandler().filter(request, response);
        }
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    protected abstract void doFilter(Request filterRequest, Response response);

}

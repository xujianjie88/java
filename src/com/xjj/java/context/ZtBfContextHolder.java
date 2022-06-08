package com.xjj.java.context;

public class ZtBfContextHolder {

    private static ThreadLocal<ZtBfContext> ztBfContextThreadLocal = new InheritableThreadLocal<ZtBfContext>();

    public static void initZtHfContext(ZtBfContext ztBfContext){
        ztBfContextThreadLocal.set(ztBfContext);
    }

    public static ZtBfContext getCurrentContext(){
        return ztBfContextThreadLocal.get();
    }

    public static void clearContext(){
        ztBfContextThreadLocal.remove();
    }

}

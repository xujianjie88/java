package com.xjj.java.context;

public class ContextTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                start(Long.parseLong(String.valueOf(finalI)));
                doing();
                finish();
            },"Thread"+finalI).start();
        }

    }

    private static void finish() {
        ZtBfContextHolder.clearContext();
    }

    private static void doing() {
        System.out.println(Thread.currentThread().getName()+":"+ZtBfContextHolder.getCurrentContext().getOrgId());
    }

    private static void start(Long orgId) {
        ZtBfContext ztBfContext = new ZtBfContext();
        ztBfContext.setOrgId(orgId);
        ZtBfContextHolder.initZtHfContext(ztBfContext);
    }


}

//package com.xjj.java.designpattern.handler2;
//
//import com.google.common.collect.Maps;
//import com.ttk.biz.invoice.task.handler.annotation.FetchInvoiceTypeAnnotation;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//public class FetchInvoiceHandlerFactory implements BeanPostProcessor {
//
//    private static Map<String,IFetchInvoiceHandler> factoryMap = Maps.newHashMap();
//
//    public static IFetchInvoiceHandler getFetchInvoiceHandler(String fetchInvoiceType){
//        return factoryMap.get(fetchInvoiceType);
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
//        return o;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
//        FetchInvoiceTypeAnnotation fetchInvoiceType = object.getClass().getAnnotation(FetchInvoiceTypeAnnotation.class);
//        if (null != fetchInvoiceType){
//            String dataType = fetchInvoiceType.value();
//            factoryMap.put(dataType,(IFetchInvoiceHandler)object);
//        }
//        return object;
//    }
//
//}

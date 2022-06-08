//package com.xjj.java.designpattern.handler;
//
//import com.google.common.collect.Maps;
//import com.ttk.edf.job.export.annotation.DataResolveType;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * @author:linxiaojun
// * @Description:
// * @Date:Created in 16:17 2018-07-27
// * @Modified By:
// */
//@Component
//public class DataResolveHandlerFactory implements BeanPostProcessor {
//
//    private static Map<String,IDataResolveHandler> factoryMap = Maps.newHashMap();
//
//    public static IDataResolveHandler getDataResolveHandler(String dataType){
//        return factoryMap.get(dataType);
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
//        return o;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
//        DataResolveType dataResolveType = object.getClass().getAnnotation(DataResolveType.class);
//        if (null != dataResolveType){
//            String dataType = dataResolveType.value();
//            factoryMap.put(dataType,(IDataResolveHandler)object);
//        }
//        return object;
//    }
//
//}

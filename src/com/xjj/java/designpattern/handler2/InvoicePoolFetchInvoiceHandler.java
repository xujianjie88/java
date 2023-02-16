//package com.xjj.java.designpattern.handler2;
//
//import com.alibaba.fastjson.JSONObject;
//import com.beust.jcommander.internal.Lists;
//import com.ttk.biz.invoice.common.impl.InvoiceCollectionConfig;
//import com.ttk.biz.invoice.config.BizInvoiceCollectionTaskConfig;
//import com.ttk.biz.invoice.constants.FetchInvoiceTaskConstants;
//import com.ttk.biz.invoice.dto.BizInvoiceCollectionTaskDto;
//import com.ttk.biz.invoice.dto.QueryBizInvoiceCollectionTaskDto;
//import com.ttk.biz.invoice.enums.TaskStateEnum;
//import com.ttk.biz.invoice.itf.IBizInvoiceCollectionTaskExtService;
//import com.ttk.biz.invoice.itf.IBizInvoiceCollectionTaskService;
//import com.ttk.biz.invoice.task.handler.annotation.FetchInvoiceTypeAnnotation;
//import com.ttk.biz.invoice.task.handler.dto.BaseFetchInvoiceParamDto;
//import com.ttk.edf.handler.event.MessageType;
//import com.ttk.edf.handler.event.RedisMessageEvent;
//import com.ttk.edf.shardingDB.TraceUtil;
//import com.ttk.edf.utils.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.SynchronousQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//
///**
// * 发票池任务处理器
// * FetchInvoiceTypeAnnotation:0-发票池任务
// */
//@Slf4j
//@Component
//@FetchInvoiceTypeAnnotation(value = FetchInvoiceTaskConstants.INVOICE_POOL_TASK)
//public class InvoicePoolFetchInvoiceHandler extends CommonFetchInvoiceFactory implements IFetchInvoiceHandler {
//
//    @Autowired
//    private IBizInvoiceCollectionTaskService bizInvoiceCollectionTaskService;
//    @Autowired
//    private IBizInvoiceCollectionTaskExtService bizInvoiceCollectionTaskExtService;
//    private BizInvoiceCollectionTaskConfig taskConfig;
//
//    @Autowired
//    private InvoiceCollectionConfig collectionConfig;
//
//    /**
//     * 任务执行线程池
//     */
//    private ThreadPoolExecutor executorService = null;
//
//    public InvoicePoolFetchInvoiceHandler() {
//        this.taskConfig = SpringUtil.getBean(BizInvoiceCollectionTaskConfig.class);
//        this.collectionConfig = SpringUtil.getBean(InvoiceCollectionConfig.class);
//        executorService = new ThreadPoolExecutor(8, taskConfig.getInvoicePoolMaxWorkIngSize(), 60, TimeUnit.SECONDS, new SynchronousQueue<>());
//    }
//
//    /**
//     * 监听配置变更事件,动态修改线程池的最大参数
//     *
//     * @param event
//     */
//    @EventListener(RedisMessageEvent.class)
//    public void changeExecutorService(RedisMessageEvent event) {
//        if (MessageType.CONFIG_LOADED.equals(event.getMessageType()) && !taskConfig.getInvoicePoolMaxWorkIngSize().equals(executorService.getMaximumPoolSize())) {
//            // 设置最大线程
//            executorService.setMaximumPoolSize(taskConfig.getInvoicePoolMaxWorkIngSize());
//        }
//    }
//
//    @Override
//    public void fetchInvoice(BaseFetchInvoiceParamDto paramDto) {
//        super.fetchInvoice(paramDto);
//    }
//
//    @Override
//    public List<BizInvoiceCollectionTaskDto> findFetchInvoiceTask(BaseFetchInvoiceParamDto paramDto) {
//
//        QueryBizInvoiceCollectionTaskDto queryTaskDto = new QueryBizInvoiceCollectionTaskDto();
//        queryTaskDto.setTaskType(paramDto.getFetchInvoiceTaskType());
//        queryTaskDto.setLimit(taskConfig.getInvoicePoolMaxWorkIngSize());
//        queryTaskDto.setXzqhDmList(collectionConfig.getFpcjUsePoolSs());
//        queryTaskDto.setTaskSource(collectionConfig.getPreparationFptqsource());
//
//        int size = executorService.getActiveCount();
//        if (size >= taskConfig.getInvoicePoolMaxWorkIngSize()) {
//            return Lists.newArrayList();
//        } else {
//            queryTaskDto.setLimit(taskConfig.getInvoicePoolMaxWorkIngSize() - size);
//        }
//
//        log.error(Thread.currentThread().getName() + "执行获取任务逻辑,活跃线程数:{},剩余窗口数:{}", size, taskConfig.getInvoicePoolMaxWorkIngSize() - size);
//
//        List<BizInvoiceCollectionTaskDto> invoiceCollectionTaskList =
//                bizInvoiceCollectionTaskExtService.queryInvoiceCollectionTaskList(queryTaskDto);
//
//        if (CollectionUtils.isNotEmpty(invoiceCollectionTaskList)) {
//            log.error(Thread.currentThread().getName() + "获取通用到任务" + invoiceCollectionTaskList.size() + "条", "结束任务查询");
//            // 更新任务状态
//            batchUpdateTaskState(invoiceCollectionTaskList);
//        }
//
//        return invoiceCollectionTaskList;
//    }
//
//    @Override
//    public void doFetchInvoiceTask(List<BizInvoiceCollectionTaskDto> taskDtoList) {
//
//        List<BizInvoiceCollectionTaskDto> undoTaskList = taskDtoList.stream()
//                .filter(taskDto -> TaskStateEnum.UNDO.getCode().equals(taskDto.getTaskState()))
//                .collect(Collectors.toList());
//
//        // 执行未处理采集任务
//        undoTaskList.forEach(taskDto -> {
//            executorService.execute(TraceUtil.getRunnable(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        invokeFetchInvoiceTask(taskDto);
//                    } catch (Exception e) {
//                        log.error(Thread.currentThread().getName()+"提交任务失败,参数:{},异常信息:{}", JSONObject.toJSONString(taskDto),e);
//                    }
//                }
//            }));
//        });
//    }
//
//}
//
//

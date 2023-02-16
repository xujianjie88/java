//package com.xjj.java.designpattern.handler2;
//
//import com.alibaba.fastjson.JSON;
//import com.ttk.biz.invoice.common.impl.InvoiceCollectionConfig;
//import com.ttk.biz.invoice.config.BizInvoiceCollectionTaskConfig;
//import com.ttk.biz.invoice.constants.FetchInvoiceTaskConstants;
//import com.ttk.biz.invoice.constants.KpxxConstants;
//import com.ttk.biz.invoice.constants.XzqhdmConstants;
//import com.ttk.biz.invoice.dto.BizInvoiceCollectionTaskDto;
//import com.ttk.biz.invoice.dto.QueryBizInvoiceCollectionTaskDto;
//import com.ttk.biz.invoice.enums.TaskStateEnum;
//import com.ttk.biz.invoice.impl.BizInvoiceAsyncUtil;
//import com.ttk.biz.invoice.itf.IBizInvoiceCollectionTaskExtService;
//import com.ttk.biz.invoice.itf.IBizInvoiceCollectionTaskService;
//import com.ttk.biz.invoice.task.handler.annotation.FetchInvoiceTypeAnnotation;
//import com.ttk.biz.invoice.task.handler.dto.BaseFetchInvoiceParamDto;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.collections4.MapUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * 开发平台取票任务(实时任务)
// * FetchInvoiceTypeAnnotation:1-实时(开放平台任务)
// */
//@Slf4j
//@Component
//@FetchInvoiceTypeAnnotation(value = FetchInvoiceTaskConstants.OPEN_PLATFORM_TASK)
//public class OpenPlatformFetchInvoiceHandler extends CommonFetchInvoiceFactory implements IFetchInvoiceHandler {
//
//    @Autowired
//    private IBizInvoiceCollectionTaskService bizInvoiceCollectionTaskService;
//
//    @Autowired
//    private IBizInvoiceCollectionTaskExtService bizInvoiceCollectionTaskExtService;
//    @Autowired
//    private BizInvoiceCollectionTaskConfig taskConfig;
//    @Autowired
//    private InvoiceCollectionConfig collectionConfig;
//
//    @Autowired
//    private BizInvoiceAsyncUtil bizInvoiceAsyncUtil;
//
//    @Autowired
//    private IBizInvoiceCollectionTaskExtService collectionTaskExtService;
//
//    @Override
//    public void fetchInvoice(BaseFetchInvoiceParamDto paramDto) {
//        super.fetchInvoice(paramDto);
//    }
//
//    @Override
//    public List<BizInvoiceCollectionTaskDto> findFetchInvoiceTask(BaseFetchInvoiceParamDto paramDto) {
//        List<BizInvoiceCollectionTaskDto> invoiceCollectionTaskList = this.getInvoiceCollectionTasks(paramDto);
//        invoiceCollectionTaskList = invoiceCollectionTaskList.stream().filter(this::taskFilterChain).collect(Collectors.toList());
//        if (CollectionUtils.isNotEmpty(invoiceCollectionTaskList)) {
//            log.error(Thread.currentThread().getName() + "获取通用到任务" + invoiceCollectionTaskList.size() + "条", "结束任务查询");
//            // 更新任务状态
//            batchUpdateTaskState(invoiceCollectionTaskList);
//        }
//
//        return invoiceCollectionTaskList;
//    }
//
//    /**
//     * 生成发票采集任务
//     *
//     * @param paramDto
//     * @return {@code List<BizInvoiceCollectionTaskDto>}
//     */
//    private List<BizInvoiceCollectionTaskDto> getInvoiceCollectionTasks(BaseFetchInvoiceParamDto paramDto) {
//        List<BizInvoiceCollectionTaskDto> collectionTaskDtos = new ArrayList<>();
//        Map<String, Object> fpcjQueuePercent = collectionConfig.getFpcjQueuePercent();
//        Map<String, Integer> availableExecutor = bizInvoiceAsyncUtil.generateAvailableExecutorSize();
//        log.error("执行获取任务逻辑,可用线程数:{}", availableExecutor);
//        if (MapUtils.isEmpty(availableExecutor)) {
//            return collectionTaskDtos;
//        }
//        for (Map.Entry<String, Object> fpcjEntry : fpcjQueuePercent.entrySet()) {
//            String ss = fpcjEntry.getKey();
//            Integer limit = availableExecutor.get(ss);
//            if (limit == null || limit == 0) {
//                continue;
//            }
//            List<BizInvoiceCollectionTaskDto> collectionTaskDtos1 = this.queryCollectionTask(paramDto, ss, limit);
//            if (CollectionUtils.isNotEmpty(collectionTaskDtos1)) {
//                collectionTaskDtos.addAll(collectionTaskDtos1);
//            }
//        }
//        return collectionTaskDtos;
//    }
//
//    private boolean taskFilterChain(BizInvoiceCollectionTaskDto taskDto) {
//        String ss = XzqhdmConstants.subtringInvoiceVersion2(taskDto.getXzqhDm());
//        if (!collectionConfig.getSmzQueueSs().contains(ss)) {
//            return true;
//        }
//        boolean flag = collectionTaskExtService.checkTaskExecutable(taskDto);
//        log.error("taskFilterChain1,nsrsbh:{},flag:{}", taskDto.getNsrsbh(), flag);
//        if (flag) {
//            flag = collectionTaskExtService.registerSmzHh(taskDto);
//        }
//        log.error("taskFilterChain2,nsrsbh:{},flag:{}", taskDto.getNsrsbh(), flag);
//        return flag;
//    }
//
//    /**
//     * 查询发票采集任务
//     *
//     * @param paramDto
//     * @param ss
//     * @param limit
//     * @return {@code List<BizInvoiceCollectionTaskDto>}
//     */
//    public List<BizInvoiceCollectionTaskDto> queryCollectionTask(BaseFetchInvoiceParamDto paramDto, String ss, Integer limit) {
//        QueryBizInvoiceCollectionTaskDto queryTaskDto = new QueryBizInvoiceCollectionTaskDto();
//        queryTaskDto.setTaskType(paramDto.getFetchInvoiceTaskType());
//        queryTaskDto.setXzqhDmList(Collections.singletonList(ss));
//        boolean flag = this.pricessXzqhDm(queryTaskDto, ss);
//        queryTaskDto.setLimit(taskConfig.getRealTimeMaxWorkIngSize());
//        queryTaskDto.setTaskSource(KpxxConstants.INVOICE_SOURCE_TYPE_0);
//        queryTaskDto.setLimit(limit);
//        log.error("queryTaskDto:{}", JSON.toJSONString(queryTaskDto));
//        if (flag) {
//            return bizInvoiceCollectionTaskExtService.queryInvoiceCollectionTaskListNotXzqhdm(queryTaskDto);
//        }
//        return bizInvoiceCollectionTaskExtService.queryInvoiceCollectionTaskList(queryTaskDto);
//    }
//
//    private boolean pricessXzqhDm(QueryBizInvoiceCollectionTaskDto queryTaskDto, String ss) {
//        if (KpxxConstants.STRING_N.equals(collectionConfig.getfpjcxxcjNotXzqhDmKqbz())) {
//            return false;
//        }
//        Map<String, Object> fpjcxxcjNotXzqhDm = collectionConfig.getFpjcxxcjNotXzqhDm();
//        if (fpjcxxcjNotXzqhDm.containsKey(ss)) {
//            queryTaskDto.setXzqhDmList(null);
//            queryTaskDto.setXzqhDm(ss);
//            queryTaskDto.setNotXzqhdm((String) fpjcxxcjNotXzqhDm.get(ss));
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void doFetchInvoiceTask(List<BizInvoiceCollectionTaskDto> taskDtoList) {
//
//        List<BizInvoiceCollectionTaskDto> undoTaskList = taskDtoList.stream()
//                .filter(taskDto -> TaskStateEnum.UNDO.getCode().equals(taskDto.getTaskState()))
//                .collect(Collectors.toList());
//        boolean flag = KpxxConstants.STRING_Y.equals(collectionConfig.getfpcjNewAsyncKqbz());
//        // 执行未处理采集任务
//        undoTaskList.forEach(taskDto -> {
//            bizInvoiceAsyncUtil.start(() -> invokeFetchInvoiceTask(taskDto));
//        });
//    }
//}

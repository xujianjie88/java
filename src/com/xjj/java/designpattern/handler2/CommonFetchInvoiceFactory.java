//package com.xjj.java.designpattern.handler2;
//
//import com.alibaba.fastjson.JSONObject;
//import com.beust.jcommander.internal.Lists;
//import com.ttk.biz.invoice.dto.BizInvoiceCollectionTaskDto;
//import com.ttk.biz.invoice.dto.InvoiceCollectionPoolReqDto;
//import com.ttk.biz.invoice.enums.TaskStateEnum;
//import com.ttk.biz.invoice.fpcj.itf.IBizInvoiceCollectionPoolService;
//import com.ttk.biz.invoice.itf.IBizInvoiceCollectionTaskExtService;
//import com.ttk.biz.invoice.task.handler.dto.BaseFetchInvoiceParamDto;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//public abstract class CommonFetchInvoiceFactory {
//
//    @Autowired
//    private IBizInvoiceCollectionTaskExtService bizInvoiceCollectionTaskExtService;
//    @Autowired
//    private IBizInvoiceCollectionPoolService bizInvoiceCollectionPoolService;
//
//    public synchronized void fetchInvoice(BaseFetchInvoiceParamDto paramDto) {
//        // 查询待处理任务
//        List<BizInvoiceCollectionTaskDto> invoiceCollectionTaskList = findFetchInvoiceTask(paramDto);
//        // 掉接口执行待处理任务
//        doFetchInvoiceTask(invoiceCollectionTaskList);
//    }
//
//    // 查找未完成的任务
//    public abstract List<BizInvoiceCollectionTaskDto> findFetchInvoiceTask(BaseFetchInvoiceParamDto paramDto);
//
//    // 执行取票逻辑
//    public abstract void doFetchInvoiceTask(List<BizInvoiceCollectionTaskDto> taskDtoList);
//
//    public void invokeFetchInvoiceTask(BizInvoiceCollectionTaskDto taskDto) {
//        InvoiceCollectionPoolReqDto poolReqDto = new InvoiceCollectionPoolReqDto();
//        poolReqDto.setDljgId(taskDto.getDljgId());
//        poolReqDto.setQyId(taskDto.getOrgId());
//        poolReqDto.setSkssq(taskDto.getSkssq());
//        poolReqDto.setNsrsbh(taskDto.getNsrsbh());
//        poolReqDto.setFplx(taskDto.getFptqlx());
//        poolReqDto.setXzqhDm(taskDto.getXzqhDm());
//        poolReqDto.setFptqSource(taskDto.getTaskSource());
//        poolReqDto.setTaskId(taskDto.getId());
//        log.error("开始调用采集接口入参,nsrsbh:{},poolReqDto:{}", taskDto.getNsrsbh(), JSONObject.toJSONString(poolReqDto));
//        bizInvoiceCollectionPoolService.fpxxCollection(poolReqDto);
//    }
//
//    public void batchUpdateTaskState(List<BizInvoiceCollectionTaskDto> taskDtoList){
//        log.error("开始执行更新任务状态逻辑,任务总条数:{}",taskDtoList.size());
//
//        // 更新任务状态列表
//        List<BizInvoiceCollectionTaskDto> updateTaskList = Lists.newArrayList();
//
//        // 更新未处理任务为处理中
//        List<BizInvoiceCollectionTaskDto> undoTaskList = taskDtoList.stream()
//                .filter(taskDto -> TaskStateEnum.UNDO.getCode().equals(taskDto.getTaskState()))
//                .collect(Collectors.toList());
//        buildUpdateDoingTaskParam(updateTaskList, undoTaskList);
//        log.error("更新【未处理】为【处理中】的任务条数为:{}",undoTaskList.size());
//
//        // 更新处理中,并且超过30分钟的任务为异常
//        List<BizInvoiceCollectionTaskDto> doingTimeOutTaskList = taskDtoList.stream()
//                .filter(taskDto -> TaskStateEnum.DOING.getCode().equals(taskDto.getTaskState()))
//                .collect(Collectors.toList());
//        buildUpdateExceptionStateTaskParam(updateTaskList, doingTimeOutTaskList);
//        log.error("更新【处理中,并且超过30分钟的任务】为【异常】的任务条数为:{}",doingTimeOutTaskList.size());
//
//        // 执行更新任务列表参数
//        if(CollectionUtils.isNotEmpty(updateTaskList)){
//            bizInvoiceCollectionTaskExtService.batchUpdateTaskState(updateTaskList);
//        }
//        log.error("=====结束执行更新任务状态逻辑=====");
//    }
//
//    private void buildUpdateExceptionStateTaskParam(List<BizInvoiceCollectionTaskDto> updateTaskList, List<BizInvoiceCollectionTaskDto> doingTimeOutTaskList) {
//        doingTimeOutTaskList.forEach(doingTask->{
//            BizInvoiceCollectionTaskDto taskDto = new BizInvoiceCollectionTaskDto();
//            taskDto.setId(doingTask.getId());
//            taskDto.setTaskState(TaskStateEnum.EXCEPTION.getCode());
//            taskDto.setTaskMsg("任务超过30分钟还在处理中,系统默认为异常状态");
//            taskDto.setXgrq(new Date());
//            updateTaskList.add(taskDto);
//        });
//    }
//
//    private void buildUpdateDoingTaskParam(List<BizInvoiceCollectionTaskDto> updateTaskList, List<BizInvoiceCollectionTaskDto> undoTaskList) {
//        undoTaskList.forEach(undoTask->{
//            BizInvoiceCollectionTaskDto taskDto = new BizInvoiceCollectionTaskDto();
//            taskDto.setId(undoTask.getId());
//            taskDto.setTaskState(TaskStateEnum.DOING.getCode());
//            Date date = new Date();
//            taskDto.setTaskBeginDate(date);
//            taskDto.setXgrq(date);
//            updateTaskList.add(taskDto);
//        });
//    }
//
//}

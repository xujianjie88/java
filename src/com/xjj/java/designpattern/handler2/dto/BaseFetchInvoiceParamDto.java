package com.xjj.java.designpattern.handler2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseFetchInvoiceParamDto {

    /**
     * 取票任务类型:0-实时取票任务,1-任务池任务
     */
    private String fetchInvoiceTaskType;

}

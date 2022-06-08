package com.xjj.java.context;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ZtBfContext {

    private Long orgId;

    private String exportFolderPath;

    private List<String> selectSqlList = new ArrayList<>();

    private List<String> insertSqlList = new ArrayList<>();

    private List<String> tableNameList = new ArrayList<>();

}

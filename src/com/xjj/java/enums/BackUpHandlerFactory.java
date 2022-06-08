package com.xjj.java.enums;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class BackUpHandlerFactory {

    private IBackUpHandler backUpHandler;

    public BackUpHandlerFactory(IBackUpHandler backUpHandler){
        this.backUpHandler = backUpHandler;
    }

    // 模板方法
    public void exportFile(ZtBfContext zfContext){
        // 拼接sql语句
        generateSelectSql();
        // 执行查询
        executeSelectSql();
        // 导出文件
        exportInsertSqlFile();
    }

    public abstract void exportInsertSqlFile();

    public abstract void generateSelectSql();

    public abstract void executeSelectSql();

}

package com.xjj.java.enums;

public class BigDataIBackUpHandler extends BackUpHandlerFactory implements IBackUpHandler {

    public BigDataIBackUpHandler(IBackUpHandler backUpHandler) {
        super(backUpHandler);
    }

    @Override
    public void doBackUp(ZtBfContext ztBfContext) {
       exportFile(ztBfContext);
    }

    @Override
    public void exportInsertSqlFile() {

    }

    @Override
    public void generateSelectSql() {

    }

    @Override
    public void executeSelectSql() {

    }
}

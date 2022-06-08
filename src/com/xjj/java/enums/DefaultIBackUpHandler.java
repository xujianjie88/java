package com.xjj.java.enums;

public class DefaultIBackUpHandler extends BackUpHandlerFactory implements IBackUpHandler {

    public DefaultIBackUpHandler(IBackUpHandler backUpHandler) {
        super(backUpHandler);
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

    @Override
    public void doBackUp(ZtBfContext ztBfContext) {
       exportFile(ztBfContext);
    }

}

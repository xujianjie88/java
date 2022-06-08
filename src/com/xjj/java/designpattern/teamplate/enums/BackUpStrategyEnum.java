package com.xjj.java.designpattern.teamplate.enums;

import com.xjj.java.designpattern.teamplate.BigDataBackUpHandler;
import com.xjj.java.designpattern.teamplate.DefaultBackUpHandler;
import com.xjj.java.designpattern.teamplate.IBackUpHandler;
import com.xjj.java.enums.BigDataIBackUpHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BackUpStrategyEnum {

    DEFAULT_BACK_UP("默认备份", "default", DefaultBackUpHandler.class),
    BIG_DATA_BACK_UP("大数据表备份", "bigdata", BigDataBackUpHandler.class);

    /**
     * 策略名称
     */
    private String name;

    /**
     * 策略值
     */
    private String value;

    /**
     * 策略处理器
     */
    private IBackUpHandler backUpHandler;

    BackUpStrategyEnum(String name, String value, Class<? extends IBackUpHandler> calzz) {
        this.name = name;
        this.value = value;
        try {
            this.backUpHandler = calzz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static IBackUpHandler getBackUpStrategyEnumByValue(String value){
        for (BackUpStrategyEnum backUpStrategyEnum : BackUpStrategyEnum.values()) {
            if (backUpStrategyEnum.getValue().equals(value)){
                return backUpStrategyEnum.getBackUpHandler();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String value = "default";
        IBackUpHandler backUpHandler = getBackUpStrategyEnumByValue(value);
        System.out.println(backUpHandler.getClass());
    }



}

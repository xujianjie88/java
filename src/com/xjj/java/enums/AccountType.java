package com.xjj.java.enums;

public enum AccountType {

    SAVING, FIXED, CURRENT,FOUR;
    private AccountType() {
        System.out.println("It is a account type");
    }

}

class EnumOne {

    public static void main(String[] args) {
        System.out.println(AccountType.FIXED);
    }

}

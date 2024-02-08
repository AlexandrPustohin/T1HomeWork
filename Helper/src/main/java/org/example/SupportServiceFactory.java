package org.example;

public class SupportServiceFactory {
    private static final SupportService INSTANCE  = new SupportServiceImpl();;

    public static SupportService getINSTANCE() {
       return INSTANCE;
    }

    public static SupportService init() {
        return new SupportServiceImpl();
    }
}

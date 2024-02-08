package org.example;

public class SupportManager {
    private  SupportService supportService;

    public SupportManager(SupportService supportService) {
        this.supportService = supportService;
    }


    public String getOfficialPhrase(){
        return String.format("Dear %s", supportService.getPhrase());
    }
}

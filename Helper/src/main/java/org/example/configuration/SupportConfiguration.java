package org.example.configuration;

import org.example.SupportManager;
import org.example.SupportService;
import org.example.SupportServiceImpl;

@Configuration
public class SupportConfiguration {
    @Instance
    public SupportManager supportManager(SupportService supportService){
        return new SupportManager(supportService);
    }
    @Instance
    public SupportService supportService(){
        return new SupportServiceImpl();
    }
}

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupportServiceTest {
    @Test
    public void testGetPhrase(){
        final SupportService supportservice = SupportServiceFactory.getINSTANCE();
        assertEquals("Hey!", supportservice.getPhrase());
    }
}

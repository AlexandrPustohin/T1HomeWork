package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class SupportManagerTest {

    @Test
    void getOfficialPhraseTest() throws InvocationTargetException, IllegalAccessException {
        var context = new ApplicationContext();
        var supportService = context.getInstance(SupportManager.class);
        assertEquals("Dear Hey!", supportService.getOfficialPhrase() );
    }
}
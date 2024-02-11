package org.example;

import org.example.entity.Phrase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SupportManagerTest {

    @Test
    void getOfficialPhraseTest() throws InvocationTargetException, IllegalAccessException {
        var context = new ApplicationContext();
        var supportServiceManager = context.getInstance(SupportManager.class);
        var supportService = context.getInstance(SupportService.class);
        supportService.addPhrase(new Phrase(Utils.TEST_PHRASE));

        assertEquals("Dear "+Utils.TEST_PHRASE, supportServiceManager.getOfficialPhrase() );
    }
}
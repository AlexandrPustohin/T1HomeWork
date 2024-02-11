package org.example;

import org.example.entity.Phrase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SupportServiceTest {
    @Test
    public void testGetPhrase(){
        final SupportService supportservice = SupportServiceFactory.getINSTANCE();
        supportservice.addPhrase(new Phrase(Utils.TEST_PHRASE));
        assertNotNull(supportservice.getRandomPhrase());
    }
}

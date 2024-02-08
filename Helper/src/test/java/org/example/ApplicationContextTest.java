package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextTest {

    @Test
    void getInstanceByClassTest() throws InvocationTargetException, IllegalAccessException {
        final var appcontext = new ApplicationContext();
        assertNotNull(appcontext.getInstance(SupportManager.class));
    }
}
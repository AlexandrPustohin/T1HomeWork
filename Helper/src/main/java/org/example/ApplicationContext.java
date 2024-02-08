package org.example;

import org.example.configuration.Configuration;
import org.example.configuration.Instance;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationContext {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public ApplicationContext() throws InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections("org.example.configuration");
        final var configurations = reflections.getTypesAnnotatedWith(Configuration.class).stream()
                .map(type -> {
                    try {
                        return type.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
        for (Object configuration: configurations) {
            List<Method> methods = Arrays.stream(configuration.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(Instance.class)).collect(Collectors.toList());
            for (Method method: methods) {
                instances.put(method.getReturnType(), method.invoke(configuration));
            }

            
        }
        
    }

    public  <T> T getInstance(Class<T> type){
        return (T) Optional.ofNullable(instances.get(type)).orElseThrow();
    }
}

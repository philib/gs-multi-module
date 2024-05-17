package com.example.multimodulelibrary;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
public class MultiModuleLibrary {

    public MultiModuleLibrary(ApplicationContext applicationContext) {
        try {
            Resource[] resources = applicationContext.getResources("classpath*:" + "someFile");
            Arrays.stream(resources).forEach(resource -> {
                try {
                    System.out.println(resource.getURL());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            if (!(resources.length == 1)) {
                System.out.println("Expected 1 resource, but found " + resources.length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

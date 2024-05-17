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
            if (resources.length == 1) {
                System.out.println("Only one resource found: " + this.getUrlString(resources[0]));
            } else {
                System.out.println("Expected 1 resource, but found " + resources.length);
                Arrays.stream(resources).forEach(this::getUrlString);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getUrlString(Resource resource) {
        try {
            return resource.getURL().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

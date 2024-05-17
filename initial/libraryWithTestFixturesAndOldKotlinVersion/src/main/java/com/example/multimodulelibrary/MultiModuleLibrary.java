
package com.example.multimodulelibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class MultiModuleLibrary {

    @Autowired
    ApplicationContext applicationContext;

    public List<Resource> getResources() {
        try {
            Resource[] resources = applicationContext.getResources("classpath*:" + "someFile");
            if (!(resources.length == 1)) {
                System.out.println("Expected 1 resource, but found: " + resources.length);
                Arrays.stream(resources).forEach(resource -> {
                    try {
                        System.out.println(resource.getURL());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                System.out.println("Found single resource: " + resources[0].getURL());
            }
            return Arrays.stream(resources).toList();
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}

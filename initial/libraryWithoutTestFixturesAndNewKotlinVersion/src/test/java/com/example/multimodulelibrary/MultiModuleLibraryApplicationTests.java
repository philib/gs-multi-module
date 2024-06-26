package com.example.multimodulelibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MultiModuleLibraryApplicationTests {
    @Autowired
    private MultiModuleLibrary multiModuleLibrary;

    @Test
    void ensure_someFile_is_found_once() {
        try {
            List<Resource> resources = multiModuleLibrary.getResources();
            resources.forEach(resource -> {
                try {
                    System.out.println(resource.getURL());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            assertThat(resources.size()).isEqualTo(1);
            assertThat(resources.get(0).getURL().toString()).containsPattern(Pattern.compile("file:.*/gs-multi-module/initial/libraryWithoutTestFixturesAndNewKotlinVersion/build/resources/main/someFile"));
        } catch (IOException e) {
            assert false;
        }
    }

}

package com.example.multimoduleapplication;

import com.example.multimodulelibrary.MultiModuleLibrary;
import org.springframework.stereotype.Component;

@Component
public class LibraryCaller {

    public LibraryCaller(MultiModuleLibrary multiModuleLibrary) {
        multiModuleLibrary.getResources();
    }

}

package com.tms.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
@Controller
public class FileCreationService {

    @Autowired
    Environment environment;
    @Value("${spring.config.activate.file_path}")
    private Path path;

    public void addCounter() throws IOException {
        if (path != null) {
            int currentIndex = getLastIndex(path) + 1;
            String line = System.lineSeparator() + currentIndex;
            Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
        }
    }

    private int getLastIndex(Path path) throws IOException {
        int lastIndex;
        String lastLine = "0";
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
        while ((currentLine = reader.readLine()) != null) {
            lastLine = currentLine;
        }
        lastIndex = Integer.parseInt(lastLine);
        return lastIndex;
    }

}

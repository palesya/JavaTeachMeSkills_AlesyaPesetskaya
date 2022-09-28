package com.tms.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {

    String read (String path) throws IOException {
        FileInputStream stream = new FileInputStream(path);
        return new String(stream.readAllBytes());
    }

    public void save(String context, String path) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        outputStream.write(context.getBytes());
    }
}

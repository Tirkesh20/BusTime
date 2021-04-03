package com.tirkesh.service;

import java.io.*;

public class FileWrite {
    public void write(String text) throws IOException {
    File file=new File("output.txt");
    if (!file.exists()){
        file.createNewFile();
    }
    FileWriter fileWriter=new FileWriter(file);
    fileWriter.write(text);
    fileWriter.flush();
    }
}

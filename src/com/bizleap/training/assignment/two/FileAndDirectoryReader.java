package com.bizleap.training.assignment.two;

import java.io.File;

public class FileAndDirectoryReader {
    
    /**
     * 1. Reading File
     * 2. Identify File Or Directory
     * 3. process File Or Directory
     */
    public void readFileAndDirectory(File entryName) {
        for (File entryFile: entryName.listFiles()) {
            String nameToPrint = entryFile.isDirectory() ? processDirectory(entryFile) : processFile(entryFile);
            System.out.println(nameToPrint);
        }
    }

    private String processDirectory(File name) {
       readFileAndDirectory(name);
       return name.getName();
    }

    private String processFile(File name) {
        return name.getName();
    }

    public static void main(String[] args) {
        new FileAndDirectoryReader().readFileAndDirectory(new File("/Users/kaung/Documents/Test"));
    }
}

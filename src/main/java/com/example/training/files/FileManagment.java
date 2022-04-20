package com.example.training.files;

import static com.example.training.files.util.Files.*;

public class FileManagment {
    public static void main(String[] args) {
        String fileName = "c:\\Training\\javaTestFile.txt";

        createFile(fileName);
        writeFile(fileName);
        readFile(fileName);
        modifyFile(fileName);
        readFile(fileName);

    }
}

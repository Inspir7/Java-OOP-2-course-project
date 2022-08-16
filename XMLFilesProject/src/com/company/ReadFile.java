package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public ReadFile() {
    }

    public File openFile(String fileData, StringBuilder data) throws IOException {
        File file = new File(fileData);

        if(!file.isFile()) {
            CreateXMLFile.createXMLFile();
        }

        readFile(file, data);

        return file;
    }

    private void readFile(File file, StringBuilder data) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                data.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object closeFile() {
        return null;
    }
}
package com.company;

import java.io.File;
import java.io.IOException;

public class FileEditor {
    private ReadFile read;
    private EditFile edit;
    private SaveFile save;
    private Validation validation;
    private File file;
    private StringBuilder data;

    public FileEditor() {
        this.read = new ReadFile();
        this.edit = new EditFile();
        this.save = new SaveFile();
        this.validation = new Validation();
        this.data = new StringBuilder();
    }

    public void open(String fileData) {
        if(validation.isFileOpened(this.file)) {
            System.out.println("You have opened file");

            return;
        }
        try {
            this.file = read.openFile(fileData, this.data);

            System.out.println("Successfully opened the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if(validation.isFileOpened(this.file)) {
            this.file = (File) read.closeFile();
            this.data.setLength(0);

            System.out.println("File closed");
        }else{
            System.out.println("Not opened file");
        }
    }

    public void save() {
        if(!validation.isFileOpened(this.file)) {
            System.out.println("You don't have opened file");

            return;
        }

        save.save(this.file, String.valueOf(this.data));

        System.out.println("You saved successfully");
    }

    public void saveAs(String fileData) {
        if(!validation.isFileOpened(this.file)) {
            System.out.println("You don't have opened file");

            return;
        }
        save.saveAs(fileData, String.valueOf(this.data));
        System.out.println("You saved successfully");
    }

    public void help() {
        edit.help();
    }
}
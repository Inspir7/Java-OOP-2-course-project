package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileEditor {
    private final ReadFile read;
    private final SaveFile save;
    private final Validation validation;
    private File file;
    private final StringBuilder data;

    public FileEditor() {
        this.read = new ReadFile();
        this.save = new SaveFile();
        this.validation = new Validation();
        this.data = new StringBuilder();
    }

    public void open(String fileData) {
        if (validation.isFileOpened(this.file)) {
            System.out.println("Successfully opened the file");
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
        if (validation.isFileOpened(this.file)) {
            this.file = (File) read.closeFile();
            this.data.setLength(0);

            System.out.println("File closed");
        } else {
            System.out.println("Haven't opened a file");
        }
    }

    public void save() {
        if (!validation.isFileOpened(this.file)) {
            System.out.println("Haven't opened a file");
            return;
        }

        save.save(this.file, String.valueOf(this.data));
        System.out.println("You saved successfully");
    }

    public void saveAs(String fileData) {
        if (!validation.isFileOpened(this.file)) {
            System.out.println("Haven't opened a file");
            return;
        }
        save.saveAs(fileData, String.valueOf(this.data));
        System.out.println("You saved successfully");
    }

    public void help() {
        System.out.println("""
                The following commands are supported:
                 open <file>      opens <file>
                 close            closes currently opened file
                 save             saves the currently open file
                 save as <file>   saves the currently open file in <file>
                 help             prints valid commands
                 print            prints information in file
                 select id        shows info for a person with the current id
                 children id      shows the attributes of a chosen element
                 exit             exists the program""");
    }

    public void print() {
        try {
            Scanner scanner = new Scanner(new FileInputStream("xmlfile.xml"));
            String[] data = scanner.nextLine().split("><");
            for (int i = 1; i < data.length; i++) {
                if (data[i].contains("person")) {
                    System.out.println("\t<" + data[i] + ">");
                } else if (data[i].contains("name") || data[i].contains("address")) {
                    System.out.println("\t\t<" + data[i] + ">");
                } else if (data[i].contains("/people")) {
                    System.out.println("<" + data[i]);
                } else {
                    System.out.println("<" + data[i] + ">");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void select(int idOfPerson) {
        int id = 0;
        String name = "Name: ";
        String address = "Address: ";
        Map<Integer, String> selector = new LinkedHashMap<>();

        try {
            Scanner scanner = new Scanner(new FileInputStream("xmlfile.xml"));
            String[] data = scanner.nextLine().split("><");

            for (int i = 1; i < data.length; i++) {
                if (data[i].contains("id=")) {
                    id = Integer.parseInt(data[i].substring(11, data[i].length() - 1));
                } else if (data[i].contains("name>")) {
                    name = name + data[i].substring(5, data[i].length() - 6);
                } else if (data[i].contains("address>")) {
                    address = address + data[i].substring(8, data[i].length() - 9);
                    String result = String.format("%s%n%s", name, address);
                    selector.put(id, result);
                    name = "Name: ";
                    address = "Address: ";
                    id = 0;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(selector.get(idOfPerson));
    }

    public void children(int idOfPerson) {
        int id = 0;
        String result = "";
        Map<Integer, String> selector = new LinkedHashMap<>();

        try {
            Scanner scanner = new Scanner(new FileInputStream("xmlfile.xml"));
            String[] data = scanner.nextLine().split("><");

            for (int i = 1; i < data.length; i++) {
                if (data[i].contains("id=")) {
                    id = Integer.parseInt(data[i].substring(11, data[i].length() - 1));
                } else if (data[i].contains("name>")) {
                    result = result + data[i].substring(0, 4) + "\n";
                } else if (data[i].contains("address>")) {
                    result = result + data[i].substring(0, 7);
                    selector.put(id, result);
                    id = 0;
                    result = "";
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(selector.get(idOfPerson));
    }
}
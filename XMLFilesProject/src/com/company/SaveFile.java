package com.company;

import java.io.*;

public class SaveFile {
    public SaveFile() {
    }

    public void save(File file, String data) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("");
            bw.write(data);

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs(String fileData, String data) {
        File file = new File(fileData);
        if(!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("");
            bw.write(data);

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.company;

import java.io.File;

public class Validation {
    public Validation() {
    }

    public boolean isFileOpened(File file) {
        return file != null;
    }

    public boolean isNullOrEmpty(String str) {
        return str.length() == 0;
    }
}

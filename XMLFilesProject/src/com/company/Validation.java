package com.company;

import java.io.File;

public class Validation {
    public Validation() {
    }

    public boolean isFileOpened(File file) {
        if(file != null)
            return true;

        return false;
    }

    public boolean isNullOrEmpty(String str) {
        if(str.length() == 0 || str == null)
            return true;

        return false;
    }
}

package com.test.filesystem;

import java.util.Collection;
import java.util.List;

public enum FileType {

    TXT, PDF, WORD;

    public static Collection<FileType> searchable() {
        return List.of(TXT, PDF, WORD);
    }
}

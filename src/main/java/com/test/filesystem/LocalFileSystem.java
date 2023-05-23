package com.test.filesystem;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class LocalFileSystem implements RemoteFilesystem {

    @NonNull
    private final String folder;

    @Override
    public Collection<FileStat> listAll() {
        // TODO: implements
        return Collections.emptyList();
    }

    @Override
    public FileContent read(@NonNull final String fileName) {
        if (fileName.isBlank()) {
            throw new IllegalArgumentException("Empty file name");
        }
        // TODO: implements
        return FileContent.EMPTY;
    }
}

package com.test.fileprocessor;

import com.test.filesystem.FileType;

import java.util.Optional;

public interface FileProcessorService {

    /**
     * Read file content form byte array
     *
     * @param content Content for reading
     * @return File content if present
     */
    Optional<String> read(byte[] content, FileType fileType);
}

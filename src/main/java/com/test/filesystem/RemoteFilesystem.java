package com.test.filesystem;

import java.util.Collection;

public interface RemoteFilesystem {

    /**
     * List of all files
     */
    Collection<FileStat> listAll();

    /**
     * Read file by name
     *
     * @param fileName File name
     * @return File content
     */
    FileContent read(String fileName);
}

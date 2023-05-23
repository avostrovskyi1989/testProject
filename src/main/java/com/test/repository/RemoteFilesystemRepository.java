package com.test.repository;

import com.test.filesystem.FileContent;
import com.test.filesystem.FileType;

import java.util.Optional;

public interface RemoteFilesystemRepository {

    /**
     * Get file content by provided name and type
     *
     * @param directoryName Directory name
     * @param type          File type
     * @return File content if present
     */
    Optional<FileContent> findLastFileInDirectory(String directoryName, FileType type);
}

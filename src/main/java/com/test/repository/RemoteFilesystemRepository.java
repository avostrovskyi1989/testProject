package com.test.repository;

import com.test.filesystem.FileContent;
import com.test.filesystem.FileType;
import com.test.filesystem.FullFileInfo;

import java.util.Optional;

public interface RemoteFilesystemRepository {

    /**
     * Get file content by provided name and type
     *
     * @param directoryName Directory name
     * @return File if present
     */
    Optional<FullFileInfo> findLastFileInDirectory(String directoryName);
}
